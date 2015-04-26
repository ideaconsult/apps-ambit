package net.idea.examples.ambit.smirks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.idea.examples.ambit.smirks.MainApp._option;

import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.interfaces.IAtom;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.SDFWriter;
import org.openscience.cdk.io.iterator.IteratingSDFReader;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import ambit2.core.helper.CDKHueckelAromaticityDetector;
import ambit2.smarts.SMIRKSManager;
import ambit2.smarts.SMIRKSReaction;

/**
 * The class that does the work.
 * 
 * @author nina
 *
 */
public class ChemWizard {
	private final static Logger LOGGER = Logger.getLogger(ChemWizard.class
			.getName());
	protected File file;

	public ChemWizard() {
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
		if (argument != null)
			argument = argument.trim();
		switch (option) {
		case file: {
			if ((argument == null) || "".equals(argument.trim()))
				return;
			setFile(new File(argument));
		}
		default:
		}
	}

	private enum FIELD {
		SMILES_Kekule, SMILES_Aromatic
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int process() throws Exception {
		if (file == null)
			throw new Exception(
					"File not assigned! Use -f command line option.");
		if (!file.exists())
			throw new FileNotFoundException(file.getAbsolutePath());
		int records_read = 0;
		int records_processed = 0;
		int records_error = 0;

		InputStream in = new FileInputStream(file);
		/**
		 * cdk-io module
		 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-
		 * search;classname~IteratingMDLReader
		 */
		IteratingSDFReader reader = null;

		SDFWriter writer = new SDFWriter(new OutputStreamWriter(System.out));

		try {

			reader = new IteratingSDFReader(in,
					DefaultChemObjectBuilder.getInstance());
			LOGGER.log(Level.INFO,
					String.format("Reading %s", file.getAbsoluteFile()));
			while (reader.hasNext()) {
				/**
				 * Note recent versions allow IAtomContainer molecule =
				 * reader.next();
				 */
				Object object = reader.next();
				IAtomContainer molecule = null;
				if (object instanceof IAtomContainer)
					molecule = (IAtomContainer) object;
				else
					break;

				records_read++;
				try {
					/**
					 * cdk-standard module
					 */
					AtomContainerManipulator
							.percieveAtomTypesAndConfigureAtoms(molecule);
					// CDKHueckelAromaticityDetector.detectAromaticity(molecule);
					for (IAtom atom : molecule.atoms())
						if (atom.getImplicitHydrogenCount() == null) {
							LOGGER.fine(atom.getSymbol() + "\t"
									+ atom.getAtomTypeName() + "\t"
									+ atom.getImplicitHydrogenCount());
							atom.setImplicitHydrogenCount(0);

						}

					molecule = AtomContainerManipulator
							.copyAndSuppressedHydrogens(molecule);

					/**
					 * Generate SMILES and assign as properties
					 */
					assignSMILES(molecule);
					molecule.setProperty("REACTION", "REACTANT");
					molecule.setProperty("SMIRKS", "");
					/**
					 * Apply reactions
					 */
					writer.write(molecule);
					for (int r = 0; r < smirks.length; r++) {
						if (reactions[r] == null) {
							reactions[r] = smrkMan.parse(smirks[r][1]);
						}
						IAtomContainer reactant = molecule.clone();
						if (smrkMan.applyTransformation(reactant, reactions[r])) {
							AtomContainerManipulator
									.percieveAtomTypesAndConfigureAtoms(reactant);
							reactant.setProperty("REACTION", "PRODUCT OF "
									+ smirks[r][0]);
							reactant.setProperty("SMIRKS", smirks[r][1]);
							try {
								assignSMILES(reactant);
							} catch (Exception x) {
								reactant.setProperty(FIELD.SMILES_Kekule,
										x.getMessage());
							}
							writer.write(reactant);
						}

					}
					records_processed++;
					;
				} catch (Exception x) {
					System.err.println("*");
					records_error++;
					LOGGER.log(Level.SEVERE, String.format(
							"[Record %d] Error %s\n", records_read,
							file.getAbsoluteFile()), x);
				}

			}
		} catch (Exception x) {
			x.printStackTrace();
			LOGGER.log(
					Level.SEVERE,
					String.format("[Record %d] Error %s\n", records_read,
							file.getAbsoluteFile()), x);
		} finally {
			try {
				reader.close();
			} catch (Exception x) {
			}
			try {
				writer.close();
			} catch (Exception x) {
			}
		}
		LOGGER.log(Level.INFO, String.format(
				"[Records read/processed/error %d/%d/%d] %s", records_read,
				records_processed, records_error, file.getAbsoluteFile()));
		return records_read;
	}

	private SmilesGenerator smilesGenerator = new SmilesGenerator();

	private static final String[][] smirks = {
			{ "Aliphatic hydroxylation", "[C;X4:1][H:2]>>[C:1][O][H:2]" },
			{ "Aromatic hydroxylation", "[c:1][H:2]>>[c:1][O][H:2]" },
			{ "O-dealkylation", "[O:1][C:2]([H])>>[O:1][H].[C:2]=[O]" },
			{ "Dioxolane demethylation",
					"[C:3]([#8:1])[#8:2]>>[#8:1].[#8:2].[C:3]=[O]" },
			{ "N-dealkylation", "[#7:1][C:2]([H])>>[#7:1][H].[C:2]=[O]" },
			{ "S-oxydation", "[#16:1] >> [#16:1](=[O])" },
			{ "Thioesther cleavage", "[#16:1][C;X3:2] >>[#16:1][H].[C;X3:2][O]" },
			{ "N-oxydation", "[#7:1][#6:2]>>[#7+:1]([O-])[#6:2]" },
			{ "Amine hydroxylation",
					"[N:1]([H:3])[#6:2]>>[N:1]([O][H:3])[#6:2]" },
			{ "Aldehyde oxidation", "[C;H1:1]=[O:2]>>[C:1](O)=[O:2]" },
			{ "Alcohol oxidation", "[C:1]([H])[O:2][H]>>[C:1]=[O:2]" },
			{ "Dihydropyrrole aromatization]",
					"[N:1]1[C:2][C:3]=[C:4][C:5]1>>[N:1]1[C:2]=[C:3][C:4]=[C:5]1" },
			{
					"Aromatization of dihydropyridines",
					"[N;X3:1]1([H])[#6:2]=[#6:3][#6;X4:4]([H])[#6:5]=[#6:6]1>>[n;H0:1]1=[#6:2][#6:3]=[#6:4][#6:5]=[#6:6]1" },
			{ "Thioester bond breaking",
					"[S:1][C:2]=[O:3]>>[S:1][H].[C:2](O)=[O:3]" },
			{ "Desulphurization of phosphor",
					"[*:1][P:2](=S)([*:3])[*:4]>>[*:1][P:2](=O)([*:3])[*:4]" },
			{ "Epoxidation", "[C:1]=[C:2]>>[C:1]1[C:2][O]1" }

	};
	private static final SMIRKSReaction[] reactions = new SMIRKSReaction[smirks.length];
	private final SMIRKSManager smrkMan = new SMIRKSManager(
			SilentChemObjectBuilder.getInstance());

	// SMIRKSReaction smr = smrkMan.parse(reaction.getSMIRKS());

	protected void assignSMILES(IAtomContainer molecule) throws Exception {

		molecule.setProperty(FIELD.SMILES_Kekule.name(), SmilesGenerator
				.unique().create(molecule));
		molecule.setProperty(FIELD.SMILES_Aromatic.name(), smilesGenerator
				.aromatic().create(molecule));

	}

}
