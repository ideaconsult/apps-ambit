package net.idea.example.ambit.appdomain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.idea.example.ambit.appdomain.MainApp._option;

import org.apache.commons.lang3.StringUtils;
import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import org.openscience.cdk.io.IChemObjectReaderErrorHandler;
import org.openscience.cdk.io.IChemObjectWriter;
import org.openscience.cdk.io.SDFWriter;
import org.openscience.cdk.io.iterator.IIteratingChemObjectReader;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.tools.CDKHydrogenAdder;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import Jama.Matrix;
import ambit2.base.exceptions.AmbitIOException;
import ambit2.core.data.model.ModelWrapper;
import ambit2.core.io.FileInputState;
import ambit2.core.io.FileOutputState;
import ambit2.core.io.InteractiveIteratingMDLReader;
import ambit2.core.processors.structure.FingerprintGenerator;
import ambit2.model.numeric.ADomainMethodType;
import ambit2.model.numeric.DataCoverage;
import ambit2.model.numeric.DataCoverageDescriptors;
import ambit2.model.structure.DataCoverageFingerprintsTanimoto;

/**
 * Applicability domain
 * @author nina
 *
 * @param <DATA>
 */
public class AppDomainModel<DATA> extends ModelWrapper<File, File, File, DataCoverage<DATA>,String>{
	protected String[] header = null;
	protected File resultFile;
	public File getResultFile() {
		return resultFile;
	}
	public void setResultFile(File resultFile) {
		this.resultFile = resultFile;
	}
	
	private final static Logger LOGGER = Logger.getLogger(AppDomainModel.class.getName());
	protected DataCoverage dataCoverage;
	
	public AppDomainModel() {
		this.dataCoverage = new DataCoverageFingerprintsTanimoto();
	}
	public AppDomainModel(DataCoverage<DATA> dataCoverage) {
		this.dataCoverage = new DataCoverageFingerprintsTanimoto();
	}
	
	public DataCoverage getDataCoverage() {
		return dataCoverage;
	}
	public void setDataCoverage(DataCoverage dataCoverage) {
		this.dataCoverage = dataCoverage;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -628626048238373558L;

	public void buildAD() throws Exception {
		LOGGER.log(Level.INFO,String.format("Method\t%s\t%s\t%s\tMetric property\t'%s'\tIn domain property\t'%s'\tthreshold\t%4.2f%%",
				dataCoverage.getAppDomainMethodType().name(),
				dataCoverage.getAppDomainMethodType(),
				dataCoverage.getClass().getName(),
				dataCoverage.getMetricName(),
				dataCoverage.getDomainName(),
				100*dataCoverage.getPThreshold()));
		
		if (dataCoverage instanceof DataCoverageDescriptors) {
			if (header == null || header.length==0) throw new Exception("Missing descriptors list. Use -f option to specify fields names to use as descriptors.");
			
			//Not most efficient way to get the number of records
			int records = process(getTrainingInstances(), new IProcessMolecule() {
				int record = 0;
				@Override
				public void processMolecule(IAtomContainer molecule) throws Exception {
					record++;
				}
			});
			final Matrix matrix = new Matrix(records,header.length);
			
			process(getTrainingInstances(), new IProcessMolecule() {
				int record = 0;
				@Override
				public void processMolecule(IAtomContainer molecule)
						throws Exception {
					for (int i=0; i < header.length; i++) {
						Object v = molecule.getProperty(header[i]);
						if (v!=null)
							matrix.set(record,i,Double.parseDouble(v.toString()));
						else 
							matrix.set(record,i,Double.NaN);
					}
					record++;
				}
			});
			dataCoverage.build(matrix);
			
		} else { //fingerprints
			final List<BitSet> bitsets = new ArrayList<BitSet>();
			process(getTrainingInstances(), new IProcessMolecule() {
				FingerprintGenerator gen = new FingerprintGenerator();
				@Override
				public void processMolecule(IAtomContainer molecule) throws Exception {
					AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(molecule);
					CDKHueckelAromaticityDetector.detectAromaticity(molecule);
					//implicit H count is NULL if read from InChI ...
					molecule = AtomContainerManipulator.removeHydrogens(molecule);
					CDKHydrogenAdder.getInstance(molecule.getBuilder()).addImplicitHydrogens(molecule);					
					bitsets.add(gen.process(molecule));
				}
			});
			dataCoverage.build(bitsets);
		}
	}
	
	/**
	 * 
	 * @param header 
	 * @throws Exception
	 */
	public void estimateAD() throws Exception {
		final IChemObjectWriter writer = createWriter();
		if (dataCoverage instanceof DataCoverageDescriptors) { 
			try {
				//prediction could be done one by one
				process(getTestInstances(), new IProcessMolecule() {
					Matrix matrix = new Matrix(1,header.length);
					@Override
					public void processMolecule(IAtomContainer molecule) throws Exception {
						//fill in the matrix
						for (int i=0; i < header.length; i++) {
							Object v = molecule.getProperty(header[i]);
							if (v!=null)
								matrix.set(0,i,Double.parseDouble(v.toString()));
							else 
								matrix.set(0,i,Double.NaN);
						}
						double[] prediction =  dataCoverage.predict(matrix);
						for (double d : prediction) {
							molecule.setProperty(dataCoverage.getName(), d);
							molecule.setProperty(dataCoverage.getDomainName(), dataCoverage.getDomain(d));
						}
						writer.write(molecule);
					}
				});
			} catch (Exception x) {
				 LOGGER.log(Level.WARNING,x.getMessage(),x);
			} finally {
				writer.close();
			}
		} else {	
			try {
				process(getTestInstances(), new IProcessMolecule() {
					
					FingerprintGenerator gen = new FingerprintGenerator();
					@Override
					public void processMolecule(IAtomContainer molecule) throws Exception {
						final List<BitSet> bitsets = new ArrayList<BitSet>();
						bitsets.add(gen.process(molecule));
						double[] prediction = dataCoverage.predict(bitsets);
						
						for (double d : prediction) {
							molecule.setProperty(dataCoverage.getName(), d);
							molecule.setProperty(dataCoverage.getDomainName(), dataCoverage.getDomain(d));
						}
						writer.write(molecule);
						/*
						System.out.print(molecule.getProperty(dataCoverage.getAppDomainMethodType().name()));
						System.out.print("\t");
						System.out.println(molecule.getProperty(dataCoverage.getDomainName()));
						*/
					}
				});
			} catch (Exception x) {
				LOGGER.log(Level.SEVERE,x.getMessage());
			} finally {
				writer.close();
			}
		}	
	}
	
	public int process(File file, IProcessMolecule processor) throws Exception {
		if (file==null) throw new Exception("File not assigned! Use -t or -s options to set input files.");
		if (!file.exists()) throw new FileNotFoundException(file.getAbsolutePath());
		int records_read = 0;
		int records_processed = 0;
		int records_error = 0;

		InputStream in = new FileInputStream(file);
		/**
		 * cdk-io module
		 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;classname~IteratingMDLReader
		 */
		IIteratingChemObjectReader<IAtomContainer> reader = null;
		try {
			/**
			 * cdk-slient module
			 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;classname~SilentChemObjectBuilder
			 */			
			reader = getReader(in,file.getName());
			LOGGER.log(Level.INFO, String.format("Reading %s",file.getAbsoluteFile()));
			LOGGER.log(Level.INFO, String.format("Writing results to "+getResultFile().getAbsolutePath()));
			while (reader.hasNext()) {
				IAtomContainer molecule  = reader.next();
				records_read++;
				if (molecule==null) {
					records_error++;
					continue;
				}
				try {
					/**
					 * ambit2-model package
					 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;quick~ambit2-model
					 */
					processor.processMolecule(molecule);
					records_processed++;;
				} catch (Exception x) {
					System.err.println("*");
					records_error++;
					LOGGER.log(Level.SEVERE, String.format("[Record %d] Error %s\n", records_read, file.getAbsoluteFile()), x);
				}

			}
		} catch (Exception x) {
			x.printStackTrace();
			LOGGER.log(Level.SEVERE, String.format("[Record %d] Error %s\n", records_read, file.getAbsoluteFile()), x);
		} finally {
			try { reader.close(); } catch (Exception x) {}
		}
		LOGGER.log(Level.FINE, String.format("[Records read/processed/error %d/%d/%d] %s", 
						records_read,records_processed,records_error,file.getAbsoluteFile()));
		return records_read;
	}

	/**
	 * Get a molecule writer (based on file extension)
	 * @return
	 * @throws Exception
	 */
	protected IChemObjectWriter createWriter() throws Exception {
		if ((resultFile==null) || resultFile.getName().toLowerCase().endsWith(FileOutputState.extensions[FileOutputState.SDF_INDEX]))
			return new SDFWriter(new OutputStreamWriter(resultFile==null?System.out:new FileOutputStream(resultFile)));
		else
			return FileOutputState.getWriter(new FileOutputStream(resultFile),resultFile.getName());
	}
	
	/**
	 * Get iterating reader, based on file extension
	 * @param in
	 * @param extension
	 * @return
	 * @throws CDKException
	 * @throws AmbitIOException
	 */
	protected IIteratingChemObjectReader<IAtomContainer> getReader(InputStream in, String extension) throws CDKException, AmbitIOException {
		FileInputState instate = new FileInputState();
		IIteratingChemObjectReader<IAtomContainer> reader ;
		if (extension.toLowerCase().endsWith(FileInputState.extensions[FileInputState.SDF_INDEX])) {
			reader = new InteractiveIteratingMDLReader(in,SilentChemObjectBuilder.getInstance());
			((InteractiveIteratingMDLReader) reader).setSkip(true);
		} else reader = instate.getReader(in,extension);
		
		reader.setReaderMode(Mode.RELAXED);
		reader.setErrorHandler(new IChemObjectReaderErrorHandler() {
			
			@Override
			public void handleError(String message, int row, int colStart, int colEnd,
					Exception exception) {
				LOGGER.log(Level.SEVERE,String.format("Error at row %d col %d - %d %s",row,colStart,colEnd,exception.getMessage()));
			}
			
			@Override
			public void handleError(String message, int row, int colStart, int colEnd) {
				LOGGER.log(Level.SEVERE,String.format("Error at row %d col %d - %d %s",row,colStart,colEnd,message));
			}
			
			@Override
			public void handleError(String message, Exception exception) {
				LOGGER.log(Level.SEVERE,message,exception);
			}
			
			@Override
			public void handleError(String message) {
				LOGGER.log(Level.SEVERE,message);
			}
		});
		return reader;
		
	}
	/**
	 * Command line options
	 * @param option
	 * @param argument
	 * @throws Exception
	 */
	public void setOption(_option option, String argument) throws Exception {
		if (argument!=null) argument = argument.trim();
		switch (option) {
		case method : {
			if ((argument==null) || "".equals(argument.trim())) throw new Exception("No method specified");
			ADomainMethodType ad = ADomainMethodType._modeFINGERPRINTS_CONSENSUS;
			try {
				ad = ADomainMethodType.valueOf(argument.trim());
			} catch (Exception x) {
				LOGGER.log(Level.WARNING,"Unknown method "+argument + ". Assuming "+ad.name());
			}
			dataCoverage =  ad.createDataCoverageObject();
			break;
		}
		case threshold : {
			try {
				dataCoverage.setPThreshold(Double.parseDouble(argument.trim()));
				if (dataCoverage.getPThreshold()<0 || dataCoverage.getPThreshold()>1) throw new Exception("Invalid threshold.");
			} catch (Exception x) {
				LOGGER.log(Level.WARNING,"Error parsing the threshold "+argument + ". Assuming threshold = 1." );
				dataCoverage.setPThreshold(1.0);
			}
			break;
		}
		case descriptors: {
			header = parseDescriptorNames(argument);
			break;
		}
		case demo: {
			String training = "Debnath_smiles.csv";
			String test = "Glende_smiles.csv";
			header = parseDescriptorNames("log_P,eLumo,eHomo,IL");
			if ((argument!=null) && "kowwin".equals(argument.trim())) {
				training = "kowwin_training.csv";
				test = "kowwin_validation.csv";				
				header = null; //no descriptors in the file
			}
			URL url = getClass().getClassLoader().getResource("net/idea/example/ambit/appdomain/"+training);
			setTrainingInstances(new File(url.getFile()));
			url = getClass().getClassLoader().getResource("net/idea/example/ambit/appdomain/"+test);
			setTestInstances(new File(url.getFile()));
			if (resultFile==null)
				setResultFile(File.createTempFile("AMBIT_",test));
			
			break;
		}
		case training: {
			if ((argument==null) || "".equals(argument.trim())) throw new Exception("No training file");
			setTrainingInstances(new File(argument));
			break;
		}
		
		case test: {
			if ((argument==null) || "".equals(argument.trim())) return;
			setTestInstances(new File(argument));
			break;
		}
		case output: {
			if ((argument==null) || "".equals(argument.trim())) return;
			setResultFile(new File(argument));
			break;			
		}
		default: 
		}
	}
	
	protected String[] parseDescriptorNames(String list) {
		String[] header = StringUtils.splitPreserveAllTokens(list,new String(","));
		if (header != null)
			for (int i=0; i < header.length; i++)
				header[i] = header[i].trim();
		return header;
		
	}
}

interface IProcessMolecule {
	void processMolecule(IAtomContainer molecule) throws Exception ;
}