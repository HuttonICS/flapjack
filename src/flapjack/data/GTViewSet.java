package flapjack.data;

import java.util.*;

/**
 * Represents a "set" of views for the genotype visualizations - basically one
 * view per chromosome for the set.
 */
public class GTViewSet
{
	private Vector<GTView> views = new Vector<GTView>();

	private String name;

	public GTViewSet()
	{
	}

	/**
	 * Constructs a new set of views for the dataset (one view per chromosome).
	 */
	public GTViewSet(DataSet dataSet, String name)
	{
		this.name = name;

		for (int i = 0; i < dataSet.countChromosomeMaps(); i++)
			views.add(new GTView(dataSet, dataSet.getMapByIndex(i)));
	}

	public String getName()
		{ return name; }

	public void setName(String name)
		{ this.name = name; }

	public Vector<GTView> getViews()
		{ return views; }

	public void setViews(Vector<GTView> views)
		{ this.views = views; }


	void recreateReferences(DataSet dataSet)
	{
		for (GTView view: views)
		{
			ChromosomeMap map = dataSet.getMapByName(view.getMapName(), false);
			view.recreateReferences(dataSet, map);
		}
	}

	public void addView(GTView view)
	{
		views.add(view);
	}

	public int getChromosomeCount()
	{
		return views.size();
	}

	public GTView getView(int index)
	{
		return views.get(index);
	}
}