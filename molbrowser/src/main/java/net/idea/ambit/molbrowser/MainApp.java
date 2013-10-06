package net.idea.ambit.molbrowser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

/**
 * Molbrowser example application
 * @author nina
 *
 */
public class MainApp {
	private static final String title = "Molbrowser";
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {
		MainApp app = new MainApp();
    	int records = app.run(args);
    	System.err.println("Records processed "+ records);
	}
	
	public int run(String[] args) {
		Options options = createOptions();
    	MolbrowserWizard worker = new MolbrowserWizard();
    	final CommandLineParser parser = new PosixParser();
		try {
		    CommandLine line = parser.parse( options, args,false );
		    if (line.hasOption(_option.help.name())) {
		    	printHelp(options, null);
		    	return -1;
		    }
		    	
	    	for (_option o: _option.values()) 
	    		if (line.hasOption(o.getShortName())) try {
	    			worker.setOption(o,line.getOptionValue(o.getShortName()));
	    		} catch (Exception x) {
	    			printHelp(options,x.getMessage());
	    			return -1;
	    		}
	    		
	    	return worker.process();	

		} catch (Exception x ) {
			printHelp(options,x.getMessage());
			return -1;
		} finally {
			try { 
				//run whatever cleanup is needed
			} catch (Exception xx) {
				printHelp(options,xx.getMessage());
			}
		}
	}
	/**
	 * 
	 * @param options
	 * @param message
	 */
	protected static void printHelp(Options options,String message) {
		if (message!=null) System.out.println(message);
		System.out.println(title);
	    HelpFormatter formatter = new HelpFormatter();
	    formatter.printHelp( MainApp.class.getName(), options );
	    System.out.println("Examples:");
	    Runtime.getRuntime().runFinalization();						 
		Runtime.getRuntime().exit(0);	
	}

	/**
	 * 
	 * @return
	 */
	protected static Options createOptions() {
    	Options options = new Options();
    	for (_option o: _option.values()) {
    		options.addOption(o.createOption());
    	}
    	return options;
	}
	/**
	 * 
	 * @author nina
	 *
	 */
	enum _option {

		file {
			@Override
			public String getArgName() {
				return "file";
			}
			@Override
			public String getDescription() {
				return "Input file name ( .sdf | .txt  | .csv | .cml ) - recognised by extension!";
			}
			@Override
			public String getShortName() {
				return "f";
			}
	
		},		
		
		output {
			@Override
			public String getArgName() {
				return "output";
			}
			@Override
			public String getDescription() {
				return "Output folder";
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
		}				
		;
		public abstract String getArgName();
		public abstract String getDescription();
		public abstract String getShortName();
		public String getDefaultValue() { return null; }
			
		public Option createOption() {
			String defaultValue = getDefaultValue();
	    	Option option   = OptionBuilder.withLongOpt(name())
	        .hasArg()
	        .withArgName(getArgName())
	        .withDescription(String.format("%s %s %s",getDescription(),defaultValue==null?"":"Default value: ",defaultValue==null?"":defaultValue))
	        .create(getShortName());

	    	return option;
		}
	}

	
}
