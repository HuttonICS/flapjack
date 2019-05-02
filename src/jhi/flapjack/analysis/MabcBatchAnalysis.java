// Copyright 2009-2019 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.flapjack.analysis;

import java.util.*;

import jhi.flapjack.data.*;
import jhi.flapjack.gui.dialog.analysis.*;

import scri.commons.gui.*;

// Batch run multiple MABC analysis tasks
public class MabcBatchAnalysis extends SimpleJob
{
	private ArrayList<GTViewSet> viewSets, resultViewSets;

	private double maxMarkerCoverage;
	private boolean simpleStats;
	private String name;

	public MabcBatchAnalysis(ArrayList<GTViewSet> viewSets, double maxMarkerCoverage, boolean simpleStats, String name)
	{
		this.viewSets = viewSets;

		this.maxMarkerCoverage = maxMarkerCoverage;
		this.simpleStats = simpleStats;
		this.name = name;

		maximum = viewSets.size();
		resultViewSets = new ArrayList<>(maximum);
	}

	public ArrayList<GTViewSet> getResultViewSets()
		{ return resultViewSets; }

	@Override
	public int getJobCount()
		{ return viewSets.size(); }


	@Override
	public void runJob(int i)
		throws Exception
	{
		System.out.println("Running analysis " + i);

		GTViewSet viewSet = viewSets.get(i);

		// If set to -1, the analysis module will either use embedded pedigree
		// data, or lines at indices 0 and 1 if that fails
		int rpIndex = -1;
		int dpIndex = -1;
		// TODO: SET TO WHAT?
		boolean excludeParents = true;

		// Use a CSD dialog (without showing it) to get a suitable selected set
		ChromosomeSelectionDialog csd = new ChromosomeSelectionDialog(viewSet, true, false);
		boolean[] selectedChromosomes = csd.getSelectedChromosomes();

		MabcAnalysis stats = new MabcAnalysis(
			viewSet, selectedChromosomes, maxMarkerCoverage, rpIndex,
			dpIndex, excludeParents, simpleStats, name);

		stats.runJob(0);
		resultViewSets.add(stats.getViewSet());

		progress++;
	}
}