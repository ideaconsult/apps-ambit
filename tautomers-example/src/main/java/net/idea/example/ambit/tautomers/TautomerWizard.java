package net.idea.example.ambit.tautomers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.idea.example.ambit.tautomers.MainApp._option;
import net.idea.example.ambit.writers.RDFTautomersWriter;

import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.inchi.InChIGenerator;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IBond;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import org.openscience.cdk.io.IChemObjectReaderErrorHandler;
import org.openscience.cdk.io.IChemObjectWriter;
import org.openscience.cdk.io.SDFWriter;
import org.openscience.cdk.io.iterator.IIteratingChemObjectReader;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.FixBondOrdersTool;
import org.openscience.cdk.tools.CDKHydrogenAdder;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import ambit2.base.exceptions.AmbitIOException;
import ambit2.core.io.DelimitedFileFormat;
import ambit2.core.io.FileInputState;
import ambit2.core.io.FileOutputState;
import ambit2.core.io.InteractiveIteratingMDLReader;
import ambit2.core.processors.structure.InchiProcessor;
import ambit2.tautomers.TautomerManager;

/**
 * The class that does the work.
 * @author nina
 *
 */
public class TautomerWizard {
	private final static Logger LOGGER = Logger.getLogger(TautomerWizard.class.getName());
	protected File file;
	protected File resultFile;
	protected boolean all = true;
	protected InchiProcessor inchiProcessor;
	protected FixBondOrdersTool kekulizer = new FixBondOrdersTool();
	
	public void setAll(boolean all) {
		this.all = all;
	}
	public File getResultFile() {
		return resultFile;
	}
	public void setResultFile(File resultFile) {
		this.resultFile = resultFile;
	}

	protected TautomerManager tautomerManager = new TautomerManager();
	
	public TautomerWizard() {
		LOGGER.setLevel(Level.FINEST);
	}
	/**
	 * 
	 * @return
	 */
	public File getFile() {
		return file;
	}
	/**
	 * 
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}
	/**
	 * 
	 * @param option
	 * @param argument
	 * @throws Exception
	 */
	public void setOption(_option option, String argument) throws Exception {
		if (argument!=null) argument = argument.trim();
		switch (option) {
		case file: {
			if ((argument==null) || "".equals(argument.trim())) return;
			setFile(new File(argument));
			break;
		}
		case output: {
			if ((argument==null) || "".equals(argument.trim())) return;
			setResultFile(new File(argument));
			break;			
		}
		case tautomers: {
			setAll(true);
			if ((argument!=null) && "best".equals(argument.trim().toLowerCase())) setAll(false);
			break;			
		}
		default: 
		}
	}

	protected IIteratingChemObjectReader<IAtomContainer> getReader(InputStream in, String extension) throws CDKException, AmbitIOException {
		FileInputState instate = new FileInputState();
		IIteratingChemObjectReader<IAtomContainer> reader ;
		if (extension.endsWith(FileInputState.extensions[FileInputState.SDF_INDEX])) {
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
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int process() throws Exception {
		if (file==null) throw new Exception("File not assigned! Use -f command line option.");
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
		
		IChemObjectWriter writer = createWriter();
		System.err.println(writer.getClass().getName());
		try {
			/**
			 * cdk-slient module
			 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;classname~SilentChemObjectBuilder
			 */			
			reader = getReader(in,file.getName());
			LOGGER.log(Level.INFO, String.format("Reading %s",file.getAbsoluteFile()));
			LOGGER.log(Level.INFO, String.format("Writing %s tautomer(s)",all?"all":"best"));
			while (reader.hasNext()) {
				/**
				 * Note recent versions allow 
				 * IAtomContainer molecule  = reader.next();
				 */
				IAtomContainer molecule  = reader.next();
				records_read++;
				if (molecule==null) {
					records_error++;
					continue;
				}
				try {
					/**
					 * cdk-standard module
					 */
					AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(molecule);
					CDKHueckelAromaticityDetector.detectAromaticity(molecule);
					//implicit H count is NULL if read from InChI ...
					molecule = AtomContainerManipulator.removeHydrogens(molecule);
					CDKHydrogenAdder.getInstance(molecule.getBuilder()).addImplicitHydrogens(molecule);
					/**
					 * ambit2-tautomers
					 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;quick~ambit2-tautomers
					 */
					Vector<IAtomContainer> resultTautomers=null;

					tautomerManager.setStructure(molecule);
					resultTautomers = tautomerManager.generateTautomersIncrementaly();
					/**
					 * Write the original structure
					 */
					molecule.setProperty("MOLECULE_NO", records_read);
					molecule.setProperty("TAUTOMER_RANK","Original structure");
					molecule.setProperty("TAUTOMER_OF_MOLECULE_NO", "");
					molecule.setProperty("InChIKey","");
					molecule.setProperty("InChI.status","");
					molecule.setProperty("InChI.msg","");
					writeResult(writer,null,molecule);
					
					/**
					 * Write results
					 */
					IAtomContainer best = null;
					double bestRank = 0;
					if (resultTautomers!=null)
					for (IAtomContainer tautomer: resultTautomers) {
						try {
							Object rank_property = tautomer.getProperty("TAUTOMER_RANK");
							if (rank_property == null) 
								LOGGER.log(Level.INFO, String.format("No tautomer rank, probably this is the original structure"));
							else {
								double rank = Double.parseDouble(rank_property.toString());
								/**
								 * The rank is energy based, lower rank is better
								 */
								if ((best==null) || (bestRank>rank)) {
									bestRank = rank;
									best = tautomer;
								}
							}
						} catch (Exception x) {
							LOGGER.log(Level.WARNING, x.getMessage());
						}
						tautomer.setProperty("TAUTOMER_OF_MOLECULE_NO", records_read);
						if (all) writeResult(writer,molecule,tautomer);
					}
					
					if (!all && (best!=null))  writeResult(writer,molecule,best);
					
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
			try { writer.close(); } catch (Exception x) {}
		}
		LOGGER.log(Level.INFO, String.format("[Records read/processed/error %d/%d/%d] %s", 
						records_read,records_processed,records_error,file.getAbsoluteFile()));
		return records_read;
	}
	

	protected IChemObjectWriter createWriter() throws Exception {
		if ((resultFile==null) || resultFile.getName().endsWith(FileOutputState.extensions[FileOutputState.SDF_INDEX]))
			return new SDFWriter(new OutputStreamWriter(resultFile==null?System.out:new FileOutputStream(resultFile)));
		else if (resultFile.getName().endsWith(".n3")) { 
			return new RDFTautomersWriter(new OutputStreamWriter(new FileOutputStream(resultFile)),new DelimitedFileFormat());
		} else
			return FileOutputState.getWriter(new FileOutputStream(resultFile),resultFile.getName());
	}
	protected void writeResult(IChemObjectWriter writer, IAtomContainer parent,IAtomContainer tautomer) throws Exception {
		if (parent!=null) {
			//don't generate InChI for the original molecule
			if (inchiProcessor==null) inchiProcessor = new InchiProcessor();
			try {
				//InChI fails on aromatic bonds, so let's Kekulize them if needed
				boolean aromatic = false;
				for (IBond bond : tautomer.bonds()) if (bond.getFlag(CDKConstants.ISAROMATIC)) {aromatic = true; break;}
				IAtomContainer kekulized = tautomer;
				if (aromatic) {
					kekulized = kekulizer.kekuliseAromaticRings((IMolecule)tautomer);
					for (IBond bond : kekulized.bonds()) if (bond.getFlag(CDKConstants.ISAROMATIC)) 
						bond.setFlag(CDKConstants.ISAROMATIC,false);
				}
				InChIGenerator generator = inchiProcessor.process(kekulized);
				
				tautomer.setProperty("InChI",generator.getInchi());
				tautomer.setProperty("InChIKey",generator.getInchiKey());
				tautomer.setProperty("InChI.status",generator.getReturnStatus().name());
				tautomer.setProperty("InChI.msg",generator.getMessage()==null?"":generator.getMessage());
				if (parent.getProperty("InChI")!=null)
					tautomer.setProperty("tautomerOf",parent.getProperty("InChI"));
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
		//if (writer instanceof SDFWriter) ((SDFWriter)writer).
		writer.write(tautomer);
	}
}
