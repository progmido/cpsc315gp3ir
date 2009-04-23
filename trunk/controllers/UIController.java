/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import javax.swing.JFileChooser;
import ui.ListPanel;
import ui.MainFrame;
import ui.QueryPanel;
import ui.ResultsDisplay;
import ui.VisualPanel;

/**
 * <b>UIController</b> 
 * <p>Handles UI events.  The main purpose of the UIController
 * is to logically separate UI upkeep from the UI classes while providing a seamless
 * transition between visualization and traditional UI to the user.</p>
 */
public class UIController
{
	// Private, thread safe instance of the controller.
    private static class Holder
    {
        private static UIController instance = new UIController();
    }

    // Private constructor
    private UIController()
    {
    }

     /**
     * Call for singleton to gain access to the methods inside the DataController
     * @return Instance of the controller.
     */
    public static UIController getInstance()
    {
        return Holder.instance;
    }

    /**
     * Set the application's frame to be managed.
     * @param frame - Frame for the application
     */
    public void setFrame(MainFrame frame)
    {
        mFrame = frame;
    }

    /**
     * Get a reference to the frame
     */
    public MainFrame getFrame()
    {
        return mFrame;
    }

    /**
     * Adds the panel to the UI that enables the user to make text-based
     * queries.
     * @param searcher - QueryPanel for entering queries
     */
    public void setSearcher(QueryPanel searcher)
    {
        mSearcher = searcher;
    }

    /**
     * Retrieves a handle to the panel for entering searches
     * @return the JPanel for searching
     */
    public QueryPanel getSearcher()
    {
        return mSearcher;
    }
    
    /**
     * Set the Visualizer panel
     * @param visualizer - JPanel for presenting a visual representation of
     * search results
     */
    public void setVisualizer(VisualPanel visualizer)
    {
    	mVisualizer = visualizer;
    }
    
    /**
     * Get a reference to the Visualizer
     */
    public VisualPanel getVisualizer()
    {
    	return mVisualizer;
    }
    
    /**
     * Set the List panel for a list of search results.
     * @param listPanel - JPanel for containing a list of search results
     */
    public void setListPanel(ListPanel listPanel)
    {
    	mList = listPanel;
    }
    
    /**
     * Returns a reference to panel with a list of results
     * @return panel containing a graphical list of search results
     */
    public ListPanel getListPanel()
    {
    	return mList;
    }

    public void setListConfiguration()
    {
        isListViewSet = true;
        mFrame.setSplitterPosition(dividerPosition);
        mFrame.setConfiguration(mSearcher, mList);
    }

    public void setVisualConfiguration()
    {
        isListViewSet = false;
        mFrame.setSplitterPosition(dividerPosition);
        mFrame.setConfiguration(mSearcher, mVisualizer);
    }

    public boolean isListViewSet()
    {
        return isListViewSet;
    }

    // TODO Finish the JFileChooser for reading in the search directory
    public void getMainDirectory()
    {
        JFileChooser getDirectory = new JFileChooser();


    }
    
    // Members
    private final double dividerPosition = 0.38;

    private boolean isListViewSet;

    private MainFrame mFrame;
    private QueryPanel mSearcher;
    private ListPanel mList;
    private ResultsDisplay mCurrentPanel;
    private VisualPanel mVisualizer;
}
