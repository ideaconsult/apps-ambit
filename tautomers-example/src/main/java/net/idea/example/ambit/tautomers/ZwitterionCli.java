package net.idea.example.ambit.tautomers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.IChemObjectReaderErrorHandler;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import org.openscience.cdk.io.iterator.IIteratingChemObjectReader;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import ambit2.base.exceptions.AmbitIOException;
import ambit2.core.io.FileInputState;
import ambit2.core.io.InteractiveIteratingMDLReader;
import ambit2.smarts.SmartsHelper;
import ambit2.tautomers.zwitterion.ZwitterionManager;

public class ZwitterionCli 
{
	private static final String title = "Zwitterion CLI";

	public String inputFileName = null;
	public String outputFileName = null;
	public String inputSmiles = null;
	
	FileWriter outWriter = null;	
	ZwitterionManager zwittMan = null;
	String endLine = System.getProperty("line.separator");

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
				return "Input molecule file (*.smi, *.sdf)";
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
					+ "Please assign input SMILES or input molecules file!");
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

			zwittMan = new ZwitterionManager();
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

		
		//Create output file		
		if (outputFileName != null)
		{	
			try {
				outWriter = new FileWriter(outputFileName);
			}
			catch (Exception x) {
				System.out.println("Unable to create output file: " + outputFileName 
						+ " error: " + x.getMessage());
				return -5;
			}
		}
		
		//Iterate input file and generate zwitterions 
		zwittMan = new ZwitterionManager();		
		File file = new File (inputFileName);
		try {
			iterateInputFile(file);
		}
		catch (Exception x) {
			System.out.println("Error on iterating input file: " + outputFileName
					+ ": " + x.getMessage());
		}
		
		//Close output file	
		try {
			if (outWriter != null)
				outWriter.close();
		}
		catch (Exception x) {
			System.out.println("Error on closing output file: " + outputFileName
					+ ": " + x.getMessage());
		}

		return 0;
	}
	
	void processMolecule(IAtomContainer mol, int recordNum) throws Exception
	{	
		zwittMan.setStructure(mol);
		List<IAtomContainer> zwList = zwittMan.generateZwitterions();
		
		String out_s = ""+ recordNum + "," + SmartsHelper.moleculeToSMILES(mol, true);
		outputLine(out_s);
		
		for (int i = 0; i < zwList.size(); i++)
		{	
			out_s = ""+ recordNum + "," + SmartsHelper.moleculeToSMILES(zwList.get(i), true);
			outputLine(out_s);
		}
	}
	
	void outputLine(String line) throws Exception
	{
		if (outWriter == null)
			System.out.println(line);
		else
		{	
			outWriter.write(line);
			outWriter.write(endLine);
			outWriter.flush();
		}
	}
	
	public void iterateInputFile(File file) throws Exception
	{
		int records_read = 0;
		int records_processed = 0;
		int records_error = 0;
		
		if (!file.exists()) 
			throw new FileNotFoundException(file.getAbsolutePath());
		
		InputStream in = new FileInputStream(file);
		IIteratingChemObjectReader<IAtomContainer> reader = null;
		try 
		{
			System.out.println("Generating zwitterions for: " + file.getPath());
			
			String out_s = "Mol#,Zwitterion";
			outputLine(out_s);
			
			reader = getReader(in,file.getName());
			while (reader.hasNext()) 
			{
				IAtomContainer molecule  = reader.next();
				records_read++;
				if (molecule==null) {
					records_error++;
					System.out.println("Unable to read molecule from record #" + records_read);
					continue;
				}
				
				try
				{	
					processMolecule(molecule, records_read);
					records_processed++;
				}
				catch (Exception x)
				{
					System.out.println("Error on record #" + records_read + " " + x.getMessage());
					records_error++;
				}
			}
			
			System.out.println("Done!");
			System.out.println("records_read: " + records_read 
					+ ", records_processed: " + records_processed 
					+ ", records_error: " + records_error);
		}
		catch (Exception x1) {
			//logger.log(Level.SEVERE, String.format("[Record %d] Error %s\n", records_read, file.getAbsoluteFile()), x1);
		} 
		finally {
			try { reader.close(); } catch (Exception x) {}
		}
	}
	
	protected IIteratingChemObjectReader<IAtomContainer> getReader(InputStream in, String extension) throws CDKException, AmbitIOException {
		FileInputState instate = new FileInputState();
		IIteratingChemObjectReader<IAtomContainer> reader ;
		if (extension.endsWith(FileInputState._FILE_TYPE.SDF_INDEX.getExtension())) {
			reader = new InteractiveIteratingMDLReader(in,SilentChemObjectBuilder.getInstance());
			((InteractiveIteratingMDLReader) reader).setSkip(true);
		} else reader = instate.getReader(in,extension);
		
		reader.setReaderMode(Mode.RELAXED);
		reader.setErrorHandler(new IChemObjectReaderErrorHandler() {
			
			@Override
			public void handleError(String message, int row, int colStart, int colEnd,
					Exception exception) {
				exception.printStackTrace();
			}
			
			@Override
			public void handleError(String message, int row, int colStart, int colEnd) {
				System.out.println(message);
			}
			
			@Override
			public void handleError(String message, Exception exception) {
				exception.printStackTrace();				
			}
			
			@Override
			public void handleError(String message) {
				System.out.println(message);
			}
		});
		return reader;
	}

}