package net.idea.examle.ambit.appdomain;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

import ambit2.model.numeric.ADomainMethodType;

/**
 * Main example application
 * @author nina
 *
 */
public class MainApp {
	private static final String title = "Ambit applicability domain estimation by ambit-models package";
	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {

    	Options options = createOptions();
    	AppDomainModel model ;
    	final CommandLineParser parser = new PosixParser();
		try {
		    CommandLine line = parser.parse( options, args,false );
		    if (line.hasOption(_option.help.name())) {
		    	printHelp(options, null);
		    	return;
		    }
		    
		    if (line.hasOption(_option.method.name())) {
		    	model = new AppDomainModel();
		    	
		    	for (_option o: _option.values()) {
		    		switch (o) {
		    		case demo : {
		    			if (line.hasOption(o.getShortName())) {
			    			model.setOption(o,line.getOptionValue(o.getShortName()));
		    			}
		    		 	model.buildAD();
				    	model.estimateAD();
				    	return;
		    		}
		    		default : {
		    			if (line.hasOption(o.getShortName())) try {
			    			model.setOption(o,line.getOptionValue(o.getShortName()));
			    		} catch (Exception x) {
			    			printHelp(options,x.getMessage());
			    			return;
			    		}	
		    		}
		    		}
		    		
		    	}	
		    	model.buildAD();
		    	model.estimateAD();
		    } else throw new Exception("Applicability domain method not specified");

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
	    System.out.println(example_demo_fp());
	    System.out.println(example_demo_density());
	    System.out.println(example_density());
	    
	    
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
		
		method {
			@Override
			public String getArgName() {
				return "method";
			}
			@Override
			public String getDescription() {
				StringBuilder b = new StringBuilder();
				b.append("Applicability domain estimation method:\n");
				for (ADomainMethodType ad : ADomainMethodType.values()) {
					b.append(ad.name());
					b.append("\t(");
					b.append(ad.getName());
					b.append(")\n");
				}
				b.append("Example:\t -m _modeFINGERPRINTS");
				return b.toString();
			}
			@Override
			public String getShortName() {
				return "m";
			}
	
		},
		threshold {
			@Override
			public String getArgName() {
				return "value";
			}
			@Override
			public String getDescription() {
				return "1.0 : all compounds from training set considered in the applicability domain (default); 0.9 : 90% of compounds from training set";
			}
			@Override
			public String getShortName() {
				return "r";
			}
		},	
		output {
			@Override
			public String getArgName() {
				return "output";
			}
			@Override
			public String getDescription() {
				return "Output file (CSV,SDF)";
			}
			@Override
			public String getShortName() {
				return "o";
			}
	
		},		
		demo {
			@Override
			public String getArgName() {
				return "dataset";
			}
			@Override
			public String getDescription() {
				return "mutagenicity | kowwin";
			}
			@Override
			public String getShortName() {
				return "d";
			}
		},
	
		training {
			@Override
			public String getArgName() {
				return "file";
			}
			@Override
			public String getDescription() {
				return "Training file (CSV,SDF)";
			}
			@Override
			public String getShortName() {
				return "t";
			}
	
		},
		
		test {
			@Override
			public String getArgName() {
				return "file";
			}
			@Override
			public String getDescription() {
				return "Test file (CSV,SDF)";
			}
			@Override
			public String getShortName() {
				return "s";
			}
	
		},		
		
		descriptors {
			//
			@Override
			public String getArgName() {
				return "list";
			}
			@Override
			public String getDescription() {
				return "Comma delimited list of field names (as in the input files) to be used as descriptors.\nExample -e log_P,eLumo,eHomo,IL ";
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

	
	protected static String example_demo_density() {
		return String.format(
		"Read the demo files and apply applicability domain by probability density estimation,\nassuming all of the training set compounds are in the app.domain. : \njava -jar %s\t-m _modeDENSITY -d mutagenicity\n",
		"example-ambit-appdomain-jar-with-dependencies.jar"
		);
	}
	
	protected static String example_demo_fp() {
		return String.format(
		"Read the demo files and apply applicability domain by Tanimoto consensus fingerprint,\nassuming all of the training set compounds are in the app.domain. Results saved in result.sdf file. : \njava -jar %s\t-m _modeFINGERPRINTS_CONSENSUS -d mutagenicity -o result.csv\n",
		"example-ambit-appdomain-jar-with-dependencies.jar"
		);
	}
	
	//-m _modeDENSITY -d mutagenicity -r 0.9
	protected static String example_density() {
		return String.format(
		"Read training and test CSV files and apply applicability domain by probability density estimation,\nassuming 90%% of the training set compounds are in the app.domain. : \njava -jar %s\t-m _modeDENSITY -t Debnath_smiles.csv -s Glende_smiles.csv -f log_P,eLumo,eHomo,IL -r 0.9\n",
		"example-ambit-appdomain-jar-with-dependencies.jar"
		);

	}


}
