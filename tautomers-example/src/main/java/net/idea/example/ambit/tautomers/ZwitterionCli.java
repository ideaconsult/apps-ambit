package net.idea.example.ambit.tautomers;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import ambit2.smarts.SmartsHelper;
import ambit2.tautomers.zwitterion.ZwitterionManager;

public class ZwitterionCli 
{
	private static final String title = "Zwitterion CLI";

	public String inputFileName = null;
	public String outputFileName = null;
	public String inputSmiles = null;

	public static void main(String[] args) {
		ZwitterionCli zwitt = new ZwitterionCli();
		zwitt.run(args);
	}

	protected static Options createOptions() {
		Options options = new Options();
		for (_option o: _option.values()) {
			options.addOption(o.createOption());
		}
		return options;
	}

	protected static void printHelp(Options options,String message) {
		if (message!=null) System.out.println(message);
		System.out.println(title);
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( ZwitterionCli.class.getName(), options );
	}


	enum _option {

		smiles {
			@Override
			public String getArgName() {
				return "smiles";
			}
			@Override
			public String getDescription() {
				return "Input molecule smiles";
			}
			@Override
			public String getShortName() {
				return "s";
			}
		},

		input {
			@Override
			public String getArgName() {
				return "input";
			}
			@Override
			public String getDescription() {
				return "Input molecule file";
			}
			@Override
			public String getShortName() {
				return "i";
			}
		},

		output {
			@Override
			public String getArgName() {
				return "output";
			}
			@Override
			public String getDescription() {
				return "Output file name (*.csv)";
			}
			@Override
			public String getShortName() {
				return "o";
			}
		},

		help {
			@Override
			public String getArgName() {
				return null;
			}
			@Override
			public String getDescription() {
				return title;
			}
			@Override
			public String getShortName() {
				return "h";
			}
			@Override
			public String getDefaultValue() {
				return null;
			}
			public Option createOption() {
				Option option   = OptionBuilder.withLongOpt(name())
						.withDescription(getDescription())
						.create(getShortName());
				return option;
			}
		};

		public abstract String getArgName();
		public abstract String getDescription();
		public abstract String getShortName();
		public String getDefaultValue() { return null; }

		public Option createOption() {
			String defaultValue = getDefaultValue();
			Option option   = OptionBuilder.withLongOpt(name())
					.hasArg()
					.withArgName(getArgName())
					.withDescription(String.format("%s %s %s",getDescription(),defaultValue==null?"":"Default value:"
						,defaultValue==null?"":defaultValue))
					.create(getShortName());

			return option;
		}
	}

	public void setOption(_option option, String argument) throws Exception
	{
		if (argument != null)
			argument = argument.trim();
		switch (option) {
		case smiles: {
			if ((argument == null) || "".equals(argument.trim()))
				return;
			inputSmiles = argument;
			break;
		}
		case input: {
			if ((argument == null) || "".equals(argument.trim()))
				return;
			inputFileName = argument;
			break;
		}
		case output: {
			if ((argument == null) || "".equals(argument.trim()))
				return;
			outputFileName = argument;
			break;
		}

		}
	}

	public int run(String[] args)
	{
		Options options = createOptions();
		final CommandLineParser parser = new PosixParser();
		try {
			CommandLine line = parser.parse( options, args,false );
			if (line.hasOption(_option.help.name())) {
				printHelp(options, null);
				return -1;
			}

			for (_option o: _option.values())
				if (line.hasOption(o.getShortName())) try {
					setOption(o,line.getOptionValue(o.getShortName()));
				} catch (Exception x) {
					printHelp(options,x.getMessage());
					return -1;
				}

			return runZwittGen();

		} catch (Exception x ) {
			System.out.println("**********" + x.getMessage());
			x.printStackTrace();
			//printHelp(options,x.getMessage());
			return -1;
		} finally {
			try {
				//run whatever cleanup is needed
			} catch (Exception xx) {
				printHelp(options,xx.getMessage());
			}
		}
	}

	protected int runZwittGen() throws Exception
	{
		if ((inputFileName == null) && (inputSmiles == null))
		{
			System.out.println("No input is given! \n"
					+ "Please assign input SMILES or input molecules file)!");
			System.out.println("Use option '-h' for help.");
			return -1;
		}

		if (inputSmiles != null)
		{
			IAtomContainer mol = null;
			try {
				mol = SmartsHelper.getMoleculeFromSmiles(inputSmiles);
				AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(mol);
			}
			catch (Exception x) {
				System.out.println("Error on creating input molecule: " + x.getMessage());
				return -2;
			}

			if (mol == null)
			{
				System.out.println("Unable to create and configure input molecule from : " + inputSmiles);
				return -3;
			}

			System.out.println("Input molecule: " + inputSmiles);

			ZwitterionManager zwittMan = new ZwitterionManager();
			zwittMan.setStructure(mol);

			try {
				List<IAtomContainer> zwList = zwittMan.generateZwitterions();

				if (zwList.isEmpty())
					System.out.println("No zwitterions");
				else
				{
					System.out.println("Zwitterions:");
					for (int i = 0; i < zwList.size(); i++)
						System.out.println(SmartsHelper.moleculeToSMILES(zwList.get(i), true));
				}
			}
			catch (Exception x) {
				System.out.println("Error on zwitterion generation: " + x.getMessage());
				return -4;
			}

			return 0;
		}

		//Handle input file
		//TODO

		return 0;
	}

}