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
		MainApp app = new MainApp();
    	int records = app.run(args);
    	System.err.println("Records processed "+ records);
	}
	
	public int run(String[] args) {
		Options options = createOptions();
    	TautomerWizard worker = new TautomerWizard();
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
				return "Output file name ( .sdf | .txt  | .csv | .cml | .n3 ) - recognised by extension!";
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
		
		benchmark {
			@Override
			public String getArgName() {
				return "benchmark-file";
			}
			@Override
			public String getDescription() {
				return "Benchmarking tautomer generation time for each molecule. Benchmark info is outputted to the specified file";
			}
			@Override
			public String getShortName() {
				return "b";
			}
	
		},
		
		algorithm {
			@Override
			public String getArgName() {
				return "algorithm";
			}
			@Override
			public String getDescription() {
				return "comb: Combinatorial algorithm based on simple binary combinations; "
						+ "icomb: Improved combinatorial algorithm; "
						+ "incr: Incremental method based of Depth First Search Algorithm (default one)";
			}
			@Override
			public String getShortName() {
				return "a";
			}
	
		},
		
		maxbacktracks {
			@Override
			public String getArgName() {
				return "n";
			}
			@Override
			public String getDescription() {
				return "Maximal number <n> of backtracks performed by the incremental algorithms-DFSA (default value 100000)";
			}
			@Override
			public String getShortName() {
				return "m";
			}
	
		},
		
		maxregistrations {
			@Override
			public String getArgName() {
				return "n";
			}
			@Override
			public String getDescription() {
				return "Maximal number <n> of tautomer registrations by the combinatorial algorithms (default value 2000)";
			}
			@Override
			public String getShortName() {
				return "r";
			}
	
		},
		
		maxsubcombinations {
			@Override
			public String getArgName() {
				return "n";
			}
			@Override
			public String getDescription() {
				return "Maximal number <n> of subcombinations for the improved combinatorial algorithm (default value 100000)";
			}
			@Override
			public String getShortName() {
				return "c";
			}
	
		},
		
		estimate {
			@Override
			public String getArgName() {
				return "file";
			}
			@Override
			public String getDescription() {
				return "Estimate the number of tautomers and save data to <file>. "
						+ "Output file name ( .txt  | .csv ) - recognised by extension!";
			}
			@Override
			public String getShortName() {
				return "e";
			}
		},
		
		ruleselection {
			@Override
			public String getArgName() {
				return "mode";
			}
			@Override
			public String getDescription() {
				return "Rule selection mode: all, random";
			}
			@Override
			public String getShortName() {
				return "s";
			}
		},
		
		rulenumberlimit {
			@Override
			public String getArgName() {
				return "limit";
			}
			@Override
			public String getDescription() {
				return "The rule number limit n. If the number or found rules is larger than <limit> then "
						+ "rule selection is performed.";
			}
			@Override
			public String getShortName() {
				return "l";
			}
		},
						
		rule1_3 {
			@Override
			public String getArgName() {
				return "on/off";
			}
			@Override
			public String getDescription() {
				return "Switch on/off the usage of 1-5 shift rules (defaut value 'on', recomended always 'on')";
			}
			@Override
			public String getShortName() {
				return "3";
			}
	
		},
		
		rule1_5 {
			@Override
			public String getArgName() {
				return "on/off";
			}
			@Override
			public String getDescription() {
				return "Switch on/off the usage of 1-5 shift rules (defaut value 'on')";
			}
			@Override
			public String getShortName() {
				return "5";
			}
	
		},
		
		rule1_7 {
			@Override
			public String getArgName() {
				return "on/off";
			}
			@Override
			public String getDescription() {
				return "Switch on/off the usage of 1-7 shift rules (defaut value 'off')";
			}
			@Override
			public String getShortName() {
				return "7";
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
