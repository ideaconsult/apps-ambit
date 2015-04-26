package net.idea.examples.ambit.smirks;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

/**
 * Main example application
 * @author nina
 *
 */
public class MainApp {
	private static final String title = "SMIRKS example";
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {

    	Options options = createOptions();
    	ChemWizard worker = null;
    	final CommandLineParser parser = new PosixParser();
		try {
			worker = new ChemWizard();
		    CommandLine line = parser.parse( options, args,false );
		    if (line.hasOption(_option.help.name())) {
		    	printHelp(options, null);
		    	return;
		    }
		    	
	    	for (_option o: _option.values()) 
	    		if (line.hasOption(o.getShortName())) try {
	    			worker.setOption(o,line.getOptionValue(o.getShortName()));
	    		} catch (Exception x) {
	    			printHelp(options,x.getMessage());
	    			return;
	    		}
	    		

	    	worker.process();	

		} catch (Exception x ) {
			printHelp(options,x.getMessage());
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
	    System.out.println(example1());
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
				return "Input file";
			}
			@Override
			public String getShortName() {
				return "f";
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

	/**
	 * 
	 * @return
	 */
	protected static String example1() {
		return String.format(
		"Read file : \tjava -jar %s\t-f filename\n",
		"examples-smirks-0.0.1-SNAPSHOT.jar"
		);

	}	
}
