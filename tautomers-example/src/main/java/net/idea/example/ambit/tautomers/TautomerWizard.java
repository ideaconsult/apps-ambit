package net.idea.example.ambit.tautomers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
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
import ambit2.core.filter.MoleculeFilter;
import ambit2.core.io.DelimitedFileFormat;
import ambit2.core.io.FileInputState;
import ambit2.core.io.FileOutputState;
import ambit2.core.io.InteractiveIteratingMDLReader;
import ambit2.core.processors.structure.InchiProcessor;
import ambit2.tautomers.TautomerConst;
import ambit2.tautomers.TautomerManager;
import ambit2.tautomers.TautomerUtils;

/**
 * The class that does the work.
 * @author nina
 *
 */
public class TautomerWizard {
	protected NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
	enum on_off {
		on {
			@Override
			public boolean getValue() {
				return true;
			}
		},
		off {
			@Override
			public boolean getValue() {
				return false;
			}
		};
		public abstract boolean getValue();
	}
	
	private final static Logger LOGGER = Logger.getLogger(TautomerWizard.class.getName());
	protected File file;
	protected File resultFile;
	protected boolean all = true;
	protected InchiProcessor inchiProcessor;
	protected FixBondOrdersTool kekulizer = new FixBondOrdersTool();
	protected int algorithm = TautomerConst.GAT_Incremental;
	protected boolean benchmark = false;
	protected String benchmarkOutFile = "benchmark.csv";
	protected boolean exclude = false;
	protected String excludeOutFile = null;
		
	protected double curMoleculeCalcTime = 0;
	protected long globalBeginTime = 0;
	protected long globalEndTime = 0;
	protected double globalCalcTime = 0;
	protected String RANK = "TAUTOMER_RANK";
	protected String estimateTautomersFile = null;
	protected MoleculeFilter molecularFilter = null;
	
	protected boolean generateInchi = true;
	
	protected TautomerManager tautomerManager = new TautomerManager();
	
	public boolean getBenchmark() {
		return benchmark;
	}
	
	public void setBenchmark(boolean benchmark) {
		this.benchmark = benchmark;
	}
	
	public String getBenchmarkOutFile() {
		return benchmarkOutFile;
	}
	
	public void setBenchmarkOutFile(String benchmarkOutFile) {
		this.benchmarkOutFile = benchmarkOutFile;
	}
	
	public int getAlgorithm() {
		return algorithm;
	}
	
	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}
	
	public void setAll(boolean all) {
		this.all = all;
	}
	public File getResultFile() {
		return resultFile;
	}
	public void setResultFile(File resultFile) {
		this.resultFile = resultFile;
	}
	
	public int getMaxBackTracks() {
		return tautomerManager.maxNumOfBackTracks;		
	}
	
	public void setMaxBackTracks(int maxBackTracks) {
		tautomerManager.maxNumOfBackTracks = maxBackTracks;		
	}
	
	public int getMaxNumOfRegistrations() {
		return tautomerManager.maxNumOfTautomerRegistrations;		
	}
	
	public void setMaxNumOfRegistrations(int maxNumRegistrations) {
		tautomerManager.maxNumOfTautomerRegistrations = maxNumRegistrations;		
	}
	
	public int getMaxNumOfSubCombinations() {
		return tautomerManager.maxNumOfSubCombinations;		
	}
	
	public void setMaxNumOfSubCombinations(int maxNumOfSubCombinations) {
		tautomerManager.maxNumOfSubCombinations = maxNumOfSubCombinations;		
	}
	
	public boolean getUse13Rules(){
		return tautomerManager.getKnowledgeBase().FlagUse13Shifts;
	}
	
	public void setUse13Rules(boolean use13Rules){
		tautomerManager.getKnowledgeBase().FlagUse13Shifts = use13Rules;
	}
	
	public boolean getUse15Rules(){
		return tautomerManager.getKnowledgeBase().FlagUse15Shifts;
	}
	
	public void setUse15Rules(boolean use15Rules){
		tautomerManager.getKnowledgeBase().FlagUse15Shifts = use15Rules;
	}
	
	public boolean getUse17Rules(){
		return tautomerManager.getKnowledgeBase().FlagUse17Shifts;
	}
	
	public void setUse17Rules(boolean use17Rules){
		tautomerManager.getKnowledgeBase().FlagUse17Shifts = use17Rules;
	}
	
	public TautomerManager getTautomerManager(){
		return tautomerManager;
	}
	
	
	public TautomerWizard() {
		LOGGER.setLevel(Level.FINEST);
		//LOGGER.setLevel(Level.OFF);
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
		case benchmark: {
			setBenchmark(true);
			if (argument != null)
				benchmarkOutFile = argument;
			break;
		}
		case algorithm: {
			if (argument == null)
				throw new Exception("Option --algorithm (-a) requires argument!");
			if(argument.equals("comb"))
				setAlgorithm(TautomerConst.GAT_Comb_Pure);
			else
				if(argument.equals("icomb"))
					setAlgorithm(TautomerConst.GAT_Comb_Improved);
				else
					if(argument.equals("incr"))
						setAlgorithm(TautomerConst.GAT_Incremental);
					else
						throw new Exception("Incorrect argument \"" +argument + "\" for option --algorithm (-a)!");
			break;
		}		
		case maxbacktracks: {
			int m = Integer.parseInt(argument);
			setMaxBackTracks(m);
			break;
		}
		case maxregistrations: {
			int r = Integer.parseInt(argument);
			setMaxNumOfRegistrations(r);
			break;
		}
		case maxsubcombinations: {
			int s = Integer.parseInt(argument);
			setMaxNumOfSubCombinations(s);
			break;
		}
		case estimate: {
			estimateTautomersFile = argument;
			break;
		}
		case ruleselection: {
			if (argument.equals("all"))
				tautomerManager.getRuleSelector().setSelectionMode(TautomerConst.RSM_ALL);
			else
				if (argument.equals("random"))
					tautomerManager.getRuleSelector().setSelectionMode(TautomerConst.RSM_RANDOM);
				else
					throw new Exception("Incorrect argument \"" +argument + "\" for option --ruleselection (-s)!");
			break;
		}
		case rulenumberlimit: {
			int limit = Integer.parseInt(argument);
			tautomerManager.getRuleSelector().setRuleNumberLimit(limit);
			break;
		}
		case rule1_3: {
			boolean flag = true;
			if (argument != null)
			{	
				if (argument.equals("off"))
					flag = false;
				else
					if (!argument.equals("on"))
						throw new Exception("Incorrect argument \"" +argument + "\" for option --rule1_3 (-3)! Set it to be 'on' or 'off'.");
			}	
			setUse13Rules(flag);
			break;
		}
		case rule1_5: {
			boolean flag = true;
			if (argument != null)
			{	
				if (argument.equals("off"))
					flag = false;
				else
					if (!argument.equals("on"))
						throw new Exception("Incorrect argument \"" +argument + "\" for option --rule1_5 (-5)! Set it to be 'on' or 'off'.");
			}	
			setUse15Rules(flag);
			break;
		}
		case rule1_7: {
			boolean flag = true;
			if (argument != null)
			{	
				if (argument.equals("off"))
					flag = false;
				else
					if (!argument.equals("on"))
						throw new Exception("Incorrect argument \"" +argument + "\" for option --rule1_7 (-7)! Set it to be 'on' or 'off'.");
			}	
			setUse13Rules(flag);
			break;
		}
		case inchi: {
			try {
				generateInchi = on_off.valueOf(argument.toLowerCase()).getValue();
			} catch (Exception x) {generateInchi = true;}
			break;
		}
		case exclude: {
			exclude = true;
			excludeOutFile = argument;
			tautomerManager.FlagStopGenerationOnReachingRuleSelectorLimit = true;
			break;
		}
		case inputfilter: {
			try {
				MoleculeFilter filter = MoleculeFilter.parseFromCommandLineString(argument);
				molecularFilter = filter;
			} catch (Exception x) {
				throw new Exception("Incorrect molecule filter: " + x.getMessage());
			}			
			break;
		}
		case isomorphismcheck: {	
			boolean flag = true;
			if (argument != null)
			{	
				if (argument.equals("off"))
					flag = false;
				else
					if (!argument.equals("on"))
						throw new Exception("Incorrect argument \"" +argument + "\" for option --isomorphismcheck (-z)!");
			}	
			tautomerManager.tautomerFilter.FlagApplyDuplicationCheckIsomorphism = flag;
			break;
		}
		case inchicheck: {	
			boolean flag = true;
			if (argument != null)
			{	
				if (argument.equals("off"))
					flag = false;
				else
					if (!argument.equals("on"))
						throw new Exception("Incorrect argument \"" +argument + "\" for option --inchicheck (-n)!");
			}	
			tautomerManager.tautomerFilter.FlagApplyDuplicationCheckInChI = flag;
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
		String sep = "\t";
		String sep_exc = "\t";
		long beginRecordTime = 0;
		long endRecordTime = 0;
		String generationError = null;
				
		//tautomerManager.FlagPrintTargetMoleculeInfo = true;
		//tautomerManager.FlagPrintExtendedRuleInstances = true;
		//tautomerManager.tautomerFilter.FlagApplyDuplicationCheckIsomorphism = truee;
		//tautomerManager.tautomerFilter.FlagApplyDuplicationFilter = false;
		//tautomerManager.tautomerFilter.FlagApplyExcludeFilter = false;
		//tautomerManager.getRuleSelector().setSelectionOrder(TautomerConst.RULE_ORDER_NONE);
		//tautomerManager.getRuleSelector().setRuleNumberLimit(5);
		
		
		if (algorithm == TautomerConst.GAT_Comb_Pure || algorithm == TautomerConst.GAT_Comb_Improved)
		{	
			tautomerManager.FlagCalculateCACTVSEnergyRank = true;
			RANK = "CACTVS_ENERGY_RANK";
		}
			

		FileWriter excludeOut = null;
		FileWriter benchmarkOut = null;
		FileWriter estimateOut = null;
		
		if (estimateTautomersFile != null)
		{
			try {
				estimateOut = new FileWriter(estimateTautomersFile);
				if (estimateTautomersFile.endsWith(".csv"))
					sep = ",";
			}catch (Exception x) {
				//in case smth's wrong with the estimate file, close it and throw an error
				try {estimateOut.close(); } catch (Exception xx) {}
				throw x;
			} finally { }
		}
		else
		{	
			//Benchmarking and exclude are not performed if estimate option is selected
			if (exclude) 
			{
				try {
					excludeOut = new FileWriter(excludeOutFile);
					if (excludeOutFile.endsWith(".csv"))
						sep_exc = ",";
				}catch (Exception x) {
					//in case smth's wrong with the estimate file, close it and throw an error
					try {excludeOut.close(); } catch (Exception xx) {}
					throw x;
				} finally { }
			}
				
			if (benchmark) //Benchmarking is not performed if estimate option is selected
			try {	
				globalBeginTime = System.nanoTime();
				benchmarkOut = new FileWriter(benchmarkOutFile);
				if (benchmarkOutFile.endsWith(".csv"))	
					sep = ",";
				String headerLine = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s\n","Mol#",sep,"CalcTime(s)",sep,"TotalTime(s)",sep,
							"nTaut",sep,"nRules",sep,"nAtoms",sep,"nBonds") ;
				
				benchmarkOut.write(headerLine);			
				benchmarkOut.flush();
			} catch (Exception x) {
				//in case smth's wrong with the benchmark file, close it and throw an error
				try {benchmarkOut.close(); } catch (Exception xx) {}
				throw x;
			} finally { }
		}
		InputStream in = new FileInputStream(file);
		/**
		 * cdk-io module
		 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;classname~IteratingMDLReader
		 */
		IIteratingChemObjectReader<IAtomContainer> reader = null;
		
		IChemObjectWriter writer = null;
		if (estimateTautomersFile == null) //Tautomers are not generated if tautomer number is estimated
			writer = createWriter();
		
		if (writer != null)
			System.err.println(writer.getClass().getName());
		
		try 
		{
			reader = getReader(in,file.getName());
			LOGGER.log(Level.INFO, String.format("Reading %s",file.getAbsoluteFile()));
			LOGGER.log(Level.INFO, String.format("Writing %s tautomer(s)",all?"all":"best"));
			while (reader.hasNext()) 
			{
				beginRecordTime = System.nanoTime();
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
				
				if (molecularFilter != null)
				{
					if (!molecularFilter.useMolecule(molecule, records_read))
						continue;
				}
				
				
				try {
					
					try {
						AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(molecule);
						CDKHueckelAromaticityDetector.detectAromaticity(molecule);
						//implicit H count is NULL if read from InChI ...
						molecule = AtomContainerManipulator.removeHydrogens(molecule);
						CDKHydrogenAdder.getInstance(molecule.getBuilder()).addImplicitHydrogens(molecule);
						boolean aromatic = false;
						for (IBond bond : molecule.bonds()) if (bond.getFlag(CDKConstants.ISAROMATIC)) {aromatic = true; break;}
						if (aromatic)
							molecule = kekulizer.kekuliseAromaticRings((IMolecule)molecule);
					} catch (Exception x) {
						LOGGER.log(Level.WARNING, String.format("[Record %d] Error %s\t%s", records_read, file.getAbsoluteFile(), x.getMessage()));
					}
					
					if (estimateTautomersFile != null)
					{
						double estim = TautomerUtils.getFastTautomerCountEstimation(tautomerManager, molecule);
						
						
						String info = String.format("%d%s%s",records_read,sep,nf.format(estim));
						estimateOut.write(info);
						estimateOut.write("\n");
						if (records_read % 100 == 0) {
							estimateOut.flush();
							LOGGER.info(String.format("[Record %d] %s", records_read , info));
						}
						continue;
					}

					/**
					 * ambit2-tautomers
					 * http://ambit.uni-plovdiv.bg:8083/nexus/index.html#nexus-search;quick~ambit2-tautomers
					 */
					List<IAtomContainer> resultTautomers = null;
					try {
						generationError = null;
						resultTautomers = generateTautomers(molecule);
					} catch (Exception x) {
						/*
						 * java.lang.ArrayIndexOutOfBoundsException: 0 at ambit2.smarts.IsomorphismTester.generateNodes(IsomorphismTester.java:780)
						 */
						LOGGER.log(Level.SEVERE, String.format("[Record %d] Error %s\t%s", records_read, file.getAbsoluteFile(), x.getMessage()));
						resultTautomers = null;
						generationError = x.getMessage();
					}
					
					if (exclude)
					{
						if (tautomerManager.getStatus() == TautomerConst.STATUS_STOPPED)
						{	
							String info = "" + records_read + sep_exc + tautomerManager.getInitialRuleCount() + "\n";
							excludeOut.write(info);
							excludeOut.flush();
							LOGGER.info("--- Mol#"+records_read + "  excluded!");
							continue;
						}
					}	
					
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
							Object rank_property = tautomer.getProperty(RANK);
							if (rank_property == null) 
								LOGGER.log(Level.INFO, String.format("[Record %d] No tautomer rank, probably this is the original structure",records_read));
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
					
					//if (generationError != null) throw new Exception(generationError);
						
					if (benchmark)
					{
						globalCalcTime += curMoleculeCalcTime;
						endRecordTime = System.nanoTime();
						
						String info = String.format("%d%s%s%s%s%s%d%s%d%s%d%s%d",
								 	records_read, sep ,nf.format(curMoleculeCalcTime), sep, nf.format((endRecordTime - beginRecordTime) / 1.0e9), sep,
									((resultTautomers == null)?0:resultTautomers.size()), sep, 
									tautomerManager.getInitialRuleCount(), sep, 
									molecule.getAtomCount(), sep, molecule.getBondCount());
						benchmarkOut.write(info);
						if (generationError != null)
							benchmarkOut.write(sep + "\"Error: " + generationError+"\"");
						benchmarkOut.write("\n");
						if (records_read % 100 == 0) {
							benchmarkOut.flush();
							LOGGER.info(String.format("[Record %d] %s", records_read , info));
						}
					}
					
					records_processed++;
				} catch (Exception x) {
					records_error++;
					LOGGER.log(Level.SEVERE, String.format("[Record %d] Error %s\n", records_read, file.getAbsoluteFile()), x);
					
					if (exclude)
					{
						try {
							String info = "" + records_read + sep_exc + "Exception\n";
							excludeOut.write(info);
							excludeOut.flush();
						}
						catch (Exception x1) {}
					}
				}
			}//while
		} catch (Exception x1) {
			LOGGER.log(Level.SEVERE, String.format("[Record %d] Error %s\n", records_read, file.getAbsoluteFile()), x1);
			
		} finally {
			try { reader.close(); } catch (Exception x) {}
			if (writer != null)
				try { writer.close(); } catch (Exception x) {}
			
			if (benchmark) {	
				globalEndTime = System.nanoTime();
				double t_total = (globalEndTime-globalBeginTime)/1.0e9; //from nano sec to s.
				
				String totalTimeStat = "Total time" + sep + t_total + sep + "s\n" +
						"Generation" + sep +  globalCalcTime + sep + "s" + sep + (100.0*globalCalcTime/t_total)+sep + "%\n"+
						"IO/convert" + sep + (t_total-globalCalcTime) + sep + "s" + sep + (100.0*(t_total-globalCalcTime)/t_total) + sep + "%\n";
				
				benchmarkOut.write(totalTimeStat);
				LOGGER.info(totalTimeStat);
				try { benchmarkOut.close(); } catch (Exception x) {}
			}
			
			if (exclude)
				try { excludeOut.close(); } catch (Exception x) {}
			
			if (estimateTautomersFile != null)
				try { estimateOut.close(); } catch (Exception x) {}
			
		}
		LOGGER.log(Level.INFO, String.format("[Records read/processed/error %d/%d/%d] %s", 
						records_read,records_processed,records_error,file.getAbsoluteFile()));
		
		return records_read;
	}
	
	protected List<IAtomContainer> generateTautomers(IAtomContainer molecule) throws Exception 
	{
		long beginTime = System.nanoTime();	
		try {
			List<IAtomContainer> res = null;
			tautomerManager.setStructure(molecule);
			
			switch (algorithm)
			{
			case TautomerConst.GAT_Comb_Pure:
				res = tautomerManager.generateTautomers();	
				break;
				
			case TautomerConst.GAT_Comb_Improved:
				res = tautomerManager.generateTautomers_ImprovedCombApproach();	
				break;	
				
			case TautomerConst.GAT_Incremental:	
				res =  tautomerManager.generateTautomersIncrementaly();
				break;	
			}
			return res;
		} finally {
			long endTime = System.nanoTime();
			curMoleculeCalcTime = (endTime - beginTime) / 1.0e9; //from nano sec. to s
			tautomerManager.printDebugInfo();
		}
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
		if (parent!=null && generateInchi && tautomer.getAtomCount()>0) {
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
				tautomer.setProperty("InChIstatus",generator.getReturnStatus().name());
				tautomer.setProperty("InChI.msg",generator.getMessage()==null?"":generator.getMessage());
				if (parent.getProperty("InChI")!=null)
					tautomer.setProperty("tautomerOf",parent.getProperty("InChI"));
			} catch (Exception x) {
				LOGGER.log(Level.WARNING, x.getMessage());
			}
		}
		//if (writer instanceof SDFWriter) ((SDFWriter)writer).
		writer.write(tautomer);
	}
}
