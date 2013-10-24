package net.idea.ambit.molbrowser;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import net.idea.ambit.molbrowser.MainApp._option;

import org.openscience.cdk.aromaticity.CDKHueckelAromaticityDetector;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import org.openscience.cdk.io.IChemObjectReaderErrorHandler;
import org.openscience.cdk.io.iterator.IIteratingChemObjectReader;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.FixBondOrdersTool;
import org.openscience.cdk.tools.CDKHydrogenAdder;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import ambit2.base.exceptions.AmbitIOException;
import ambit2.base.json.JSONUtils;
import ambit2.core.data.IStructureDiagramHighlights;
import ambit2.core.io.FileInputState;
import ambit2.core.io.InteractiveIteratingMDLReader;
import ambit2.core.processors.structure.InchiProcessor;
import ambit2.rendering.CompoundImageTools;

/**
 * The class that does the work.
 * @author nina
 *
 */
public class MolbrowserWizard {
	private final static Logger LOGGER = Logger.getLogger(MolbrowserWizard.class.getName());
	protected File file;
	protected File resultFolder;
	protected boolean all = true;
	protected InchiProcessor inchiProcessor;
	protected FixBondOrdersTool kekulizer = new FixBondOrdersTool();
	protected CompoundImageTools tool = new CompoundImageTools();
	
	public void setAll(boolean all) {
		this.all = all;
	}
	public File getResultFolder() {
		return resultFolder;
	}
	public void setResultFolder(File resultFolder) {
		this.resultFolder = resultFolder;
	}

	
	public MolbrowserWizard() {
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
			setResultFolder(new File(argument));
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

			public void handleError(String message) {
				
			}

			public void handleError(String message, Exception exception) {
			}

			public void handleError(String message, int row, int colStart,
					int colEnd) {
			}

			public void handleError(String message, int row, int colStart,
					int colEnd, Exception exception) {
				
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
		if (resultFolder==null) {
			resultFolder = new File(file.getParentFile(),"molbrowser");
		} else if (!resultFolder.isDirectory()) 
			throw new Exception("A folder expected! Use -o command line option.");
		
		int records_read = 0;
		int records_processed = 0;
		int records_error = 0;


		InputStream in = new FileInputStream(file);
		/**
		 * cdk-io module
		 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;classname~IteratingMDLReader
		 */
		IIteratingChemObjectReader<IAtomContainer> reader = null;
		Writer writer = createWriter();
		jsonHeader(writer,file.getName());
		try {
			/**
			 * cdk-slient module
			 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;classname~SilentChemObjectBuilder
			 */			
			reader = getReader(in,file.getName());
			LOGGER.log(Level.INFO, String.format("Reading %s",file.getAbsoluteFile()));
			LOGGER.log(Level.INFO, String.format("Writing to %s",getResultFolder()));
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
					/*implicit H count is NULL if read from InChI ...
					molecule = AtomContainerManipulator.removeHydrogens(molecule);
					CDKHydrogenAdder.getInstance(molecule.getBuilder()).addImplicitHydrogens(molecule);
					*/
					String imgURI = getImageURI(molecule, null, getResultFolder(), UUID.randomUUID().toString());
					mol2json(molecule, imgURI, writer,records_processed);
					
					records_processed++;;
				} catch (Exception x) {
					System.err.println("*");
					records_error++;
					LOGGER.log(Level.SEVERE, String.format("[Record %d] Error %s\n", records_read, file.getAbsoluteFile()), x);
				}

			}
			jsonFooter(writer);
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
	
	protected void mol2json(IAtomContainer mol,String imgURI, Writer writer, int record) throws Exception {
		if (record>0) writer.write(",");
		writer.write("{\n");
		writer.write("\t\t\"record\":\t");
		writer.write(Integer.toString(record+1));
		writer.write(",\n");
		writer.write("\t\t\"img\":\t\"");
		writer.write(imgURI);
		writer.write("\",\n");
		writer.write("\t\t\"tags\":{\n");
		Iterator<Entry<Object,Object>> props = mol.getProperties().entrySet().iterator();
		int i= 0;
		while (props.hasNext()) {
			Entry<Object,Object> entry = props.next();
			if (i>0) writer.write(",\n");
			writer.write("\t\t\t\"");
			writer.write(JSONUtils.jsonEscape(entry.getKey().toString()));
			writer.write("\":\t");
			try {
				Double d = Double.parseDouble(entry.getValue().toString());
				writer.write(Double.toString(d));
			} catch (Exception x) {
				writer.write("\"");
				writer.write(JSONUtils.jsonEscape(entry.getValue().toString()));
				writer.write("\"");
			}
			
			i++;
		}
		writer.write("\n\t\t}\n\t}");
		writer.flush();
	}
	protected Writer createWriter() throws Exception {
		return new BufferedWriter(new FileWriter(new File(getResultFolder(),"mol.json")));
	}
	protected void jsonHeader(Writer writer,String title) throws Exception {
		writer.write("{\n");
		writer.write("\"dataset\":\t{\n");
		writer.write("\t\"name\":\"");
		writer.write(title);
		writer.write("\",");
		writer.write("\t\"molecule\":\t[\n");
	}
	protected void jsonFooter(Writer writer) throws Exception {
		writer.write("\n\t]\n}\n}");
	}
	
	protected String getImageURI(IAtomContainer ac, 
			IStructureDiagramHighlights hilights, 
			File folder, String name) {
		
		File imgFolder = new File(String.format("%s/%s/",folder,"images"));
		if (!imgFolder.exists()) imgFolder.mkdir();
		String file = String.format("%s/%s.png", imgFolder.getAbsolutePath(),name);

		try {
			//IAtomContainer c = (IAtomContainer) ac.clone();
			AtomContainerManipulator.removeHydrogensPreserveMultiplyBonded(ac);
			
			BufferedImage img = hilights==null?tool.getImage(ac,null,true,false):hilights.getImage(ac);
			ImageIO.write(img, "png",new FileOutputStream(file));
		} catch (Exception x) {
			System.out.println(file);
			//x.printStackTrace();
		}
		return String.format("images/%s.png", name);
		
	}
}
