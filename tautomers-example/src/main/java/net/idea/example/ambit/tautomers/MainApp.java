package net.idea.example.ambit.tautomers;

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
	private static final String title = "Tautomer generation by ambit-tautomers package";
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {

    	Options options = createOptions();
    	TautomerWizard worker = new TautomerWizard();
    	final CommandLineParser parser = new PosixParser();
		try {
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
	    System.out.println(example2());
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
				return "Input file (SDF)";
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
				return "Output file (SDF)";
			}
			@Override
			public String getShortName() {
				return "o";
			}
	
		},				
	
		tautomers {
			@Override
			public String getArgName() {
				return "file";
			}
			@Override
			public String getDescription() {
				return "all: Write all tautomers; best: Write only the best tautomer";
			}
			@Override
			public String getShortName() {
				return "t";
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
		"Read file and write all tautomers to the standard out : \njava -jar %s\t-f filename.sdf\n",
		"example-ambit-tautomers-jar-with-dependencies.jar"
		);

	}	
	
	/**
	 * 
	 * @return
	 */
	protected static String example2() {
		return String.format(
		"Read file and write only the best tautomers to an SDF file : \njava -jar %s\t-f filename.sdf -o tautomers.sdf -t best\n",
		"example-ambit-tautomers-jar-with-dependencies.jar"
		);

	}	
}
