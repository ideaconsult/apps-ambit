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

import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.inchi.InChIGenerator;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.IChemObjectWriter;
import org.openscience.cdk.io.SDFWriter;
import org.openscience.cdk.io.iterator.IIteratingChemObjectReader;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import ambit2.base.data.Property;
import ambit2.base.exceptions.AmbitIOException;
import ambit2.core.config.AmbitCONSTANTS;
import ambit2.core.io.FileInputState;
import ambit2.core.io.FileOutputState;
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
		return instate.getReader(in,extension);
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
				try {
					/**
					 * cdk-standard module
					 */
					AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(molecule);
					CDKHueckelAromaticityDetector.detectAromaticity(molecule);
					//implicit H count is NULL if read from InChI ...
					molecule = AtomContainerManipulator.removeHydrogens(molecule);
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
					writer.write(molecule);
					
					/**
					 * Write results
					 */
					IAtomContainer best = null;
					double bestRank = 0;
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
						if (all) writeResult(writer,tautomer);
					}
					
					if (!all && (best!=null))  writeResult(writer,best);
					
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
		else
			return FileOutputState.getWriter(new FileOutputStream(resultFile),resultFile.getName());
	}
	protected void writeResult(IChemObjectWriter writer, IAtomContainer molecule) throws Exception {
		if (inchiProcessor==null) inchiProcessor = new InchiProcessor();
		InChIGenerator generator = inchiProcessor.process(molecule);
		molecule.setProperty("InChI",generator.getInchi());
		molecule.setProperty("InChIKey",generator.getInchiKey());
		molecule.setProperty("InChI.status",generator.getReturnStatus().name());
		molecule.setProperty("InChI.msg",generator.getMessage());
		//if (writer instanceof SDFWriter) ((SDFWriter)writer).
		writer.write(molecule);
	}
}
