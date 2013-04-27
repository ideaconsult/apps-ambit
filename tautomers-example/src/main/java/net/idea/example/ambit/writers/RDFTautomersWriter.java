package net.idea.example.ambit.writers;

import java.io.IOException;
import java.io.Writer;

import org.openscience.cdk.interfaces.IAtomContainer;

import ambit2.core.io.DelimitedFileFormat;
import ambit2.core.io.DelimitedFileWriter;

/**
 * Dead simple RDF writer. Not really a DelimitedFileWriter.
 * @author nina
 *
 */
public class RDFTautomersWriter extends DelimitedFileWriter {
	IAtomContainer originalMolecule;
	public IAtomContainer getOriginalMolecule() {
		return originalMolecule;
	}
	public void setOriginalMolecule(IAtomContainer originalMolecule) {
		this.originalMolecule = originalMolecule;
	}

	public RDFTautomersWriter(Writer out, DelimitedFileFormat format) {
		super(out,format);
	}
	@Override
	protected void writeHeader() throws IOException {
		// do nothing, just the prefix
		writer.write("@prefix rom:  <http://rdf.openmolecules.net/?> .\n");
	}
	@Override
	public void writeMolecule(IAtomContainer molecule) {
      	if (!writingStarted) try {
	        writeHeader();
	        writingStarted = true;
    	} catch (IOException x) { logger.severe(x.getMessage()); }
    	
		Object parent = molecule.getProperty("tautomerOf");
		if (parent==null) return;
		Object inchi = molecule.getProperty("InChI");
		try {
			writer.write("<rom:");
			writer.write(inchi==null?"":inchi.toString());
			writer.write(">\t");
			writer.write(":tautomerOf");
			writer.write("\t");
			writer.write("<rom:");
			writer.write(parent==null?"":parent.toString());
			writer.write(">.");
			writer.write("\n");
			writer.flush();
		} catch (Exception x) {
			logger.severe(x.getMessage());
		}
	}
}
