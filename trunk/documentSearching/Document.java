/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package documentSearching;


import java.util.ArrayList;
import project3.DocumentInfo;
import project3.StemInfo.StemInstance;

/**
 * <b>Document</b>
 * 
 * <p>This class encapsulates rank and subset of a file's text.  This is returned
 * to the UI to create <code>SearchResult</code>.</p>
 */
public class Document implements DocumentInfo
{
	/**
	 * Create a <code>Document</code> for a file
	 * @param rank - the rank of the file
	 */
	public Document(String name, double rank)
	{
		mName = name;
		mRank = rank;
	}

    public double getRank()
    {
        return mRank;
    }
	
	public String getName()
	{
		return mName;
	}

    public void addInstance(StemInstance s)
    {
        stems.add(s);
    }
	
	/**
	 * Return all instances of a stem in the document
	 */
	@Override
    public ArrayList<StemInstance> getInstances(String stem)
    {
        ArrayList<StemInstance> instances = new ArrayList<StemInstance>();

        for (StemInstance si : stems)
        {
            if (si.getStem().equals(stem))
            {
                instances.add(si);
            }
        }

        return instances;
    }

    private double mRank;
    private String mName;

    private ArrayList<StemInstance> stems = new ArrayList<StemInstance>();
}
