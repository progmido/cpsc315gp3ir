/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VisualPanel.java
 *
 * Created on Apr 8, 2009, 1:32:45 AM
 */

package ui;

import javax.swing.JComponent;
import documentSearching.Document;
import prefuse.Visualization;
import prefuse.data.Table;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.LabelRenderer;

/**
 * <b>VisualPanel</b>
 *
 * <p>This class represents the window for viewing the search results of a query
 * in an interactive, visually appealing format</p>
 */
public class VisualPanel extends javax.swing.JPanel implements ResultsDisplay
{

    /** Creates new form VisualPanel
     Might need to change constructor to Document[] and get name from document object*/
    public VisualPanel(Document documents [])
    {
        initComponents();
        String doc = "Document";
        String name = "Name";
        
        data.addColumn(doc, Document.class);
        data.addColumn(name, String.class);
        data.addRows(documents.length);
        
        for(int i = 0; i < documents.length; i++){
            data.set(i, doc, documents[i]);
            data.set(i, name, documents[i].getName());
        }
        
        
        viz.add("data", data);
        
        //update later to give an image
        renderer = new LabelRenderer("Name");
        viz.setRendererFactory(new DefaultRendererFactory(renderer));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Removes all search items contained in the visual panel for another query.
     */
    public void removeSearchItems()
    {
        
    }

    /**
     * Adds a search item that is to be displayed in the visual format.
     * @param doc - <code>Document</code> to displayed
     */
    @Override
    public void addDocument(Document doc)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    Visualization viz;
    LabelRenderer renderer;
    Table data;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
