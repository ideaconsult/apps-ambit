package net.idea.example.ambit.tautomers;

import java.util.ArrayList;

import ambit2.tautomers.TautomerManager;

public class GenerationParameters 
{
	public int[] maxNumOfBackTracks = null;
	public int[] rule15 = null;	
	public int[] rule17 = null;
	
	private int nCombinations = 0;
	private int curComb = 0;
	private ArrayList<int[]> params = new ArrayList<int[]>(); 
	private ArrayList<String> paramDesignations = new ArrayList<String>(); 
	private int pos[] = null; //pointers to the current positions

		
	public void gotoFirstParamCombination()
	{
		nCombinations = 1;
		params.clear();
		paramDesignations.clear();
		
		if (maxNumOfBackTracks != null)
			if (maxNumOfBackTracks.length > 0)
			{	
				params.add(maxNumOfBackTracks);
				paramDesignations.add("m");
				nCombinations *= maxNumOfBackTracks.length;
			}
		
		if (rule15 != null)
			if (rule15.length > 0) 
			{	
				params.add(rule15);
				paramDesignations.add("r15");
				nCombinations *= rule15.length;
			}
		
		if (rule17 != null)
			if (rule17.length > 0)
			{	
				params.add(rule17);
				paramDesignations.add("r17");
				nCombinations *= rule17.length;
			}
		
		pos = new int[params.size()];
		for (int i = 0; i < pos.length; i++)
			pos[i] = 0;
	}
	
	public void gotoNextParamCombination()
	{
		for (int i = 0; i < pos.length; i++)
		{
			pos[i]++;
			if (pos[i]== params.get(i).length)
				pos[i] = 0;
			else
				break;
		}
		curComb++;
	}
	
	public boolean hasNext()
	{
		return (curComb < nCombinations);
	}
	
	public String getCombinationsAsString()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = params.size()-1; i >= 0; i--)
		{	
			sb.append(paramDesignations.get(i) + "-" + params.get(i)[pos[i]]);
			if (i > 0)
				sb.append("_");
		}
		return sb.toString();
	}
	
	public void applyCurrentParameters(TautomerManager manager)
	{
		for (int i = 0; i < params.size(); i++)
		{	
			if (params.get(i) == maxNumOfBackTracks)
				manager.maxNumOfBackTracks = maxNumOfBackTracks[pos[i]];
			else
				if (params.get(i) == rule15)
					manager.getKnowledgeBase().FlagUse15Shifts = toBoolean(rule15[pos[i]]);
				else
					if (params.get(i) == rule15)
						manager.getKnowledgeBase().FlagUse15Shifts = toBoolean(rule15[pos[i]]);
	
		}
	}
	
	
	private boolean toBoolean(int i)
	{
		return (i!=0);
	}
	
	/*
	public static GenerationParameters parseFromString(String s) throws Exception
	{
		GenerationParameters gen = new GenerationParameters();
		//TODO
		return gen;
	}
	*/
	
	
}
