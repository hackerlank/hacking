/*
 * $Id: FileViewPane.java,v 1.2 2004/12/07 17:53:22 bdickie Exp $
 *
 * Repository Explorer and Repository Grapher
 * Copyright (C) 2004 Blake Dickie
 *
 * This program is free software; you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation; either version 2 of the License, or 
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License 
 * along with this program; if not, write to the Free Software 
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 *
 */

package ca.uvic.cs.gold.bdickie.explorer;

import ca.uvic.cs.gold.bdickie.fs.*;
import ca.uvic.cs.gold.bdickie.db.DBConnection;
import ca.uvic.cs.gold.bdickie.*;
import ca.uvic.cs.gold.bdickie.explorer.difference.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;


/** A panel for displaying a File.  It has two modes, the Info mode the the
 *  View mode.  In the info mode a list of revisions is shown and in View mode
 *  the actual revision is shown.
 *
 * @author  Blake Dickie
 */
public class FileViewPane extends javax.swing.JPanel {
    private File file;
    private String revision;
    private DefaultComboBoxModel revisions;
    private static final String[] columnNames =  new String [] {
        "Revision", "Type", "Date", "Time", "Can View", "MR"};
    
    /** Creates new form FileViewPane */
    public FileViewPane(File f, String rev) {
        file = f;
        initComponents();
        setRevision(rev);
        jTable1.getSelectionModel().addListSelectionListener(new InfoTableSelectionChanged());
        jTable1.getSelectionModel().setSelectionInterval(0,0);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        infoTablePopup = new javax.swing.JPopupMenu();
        mnuViewData = new javax.swing.JMenuItem();
        mnuViewMRS = new javax.swing.JMenuItem();
        panelInfo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelView = new javax.swing.JPanel();
        scrollArea = new javax.swing.JScrollPane();
        contentBox = new javax.swing.JEditorPane();
        ControlPane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        cboDifferences = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        cmbRevisions = new javax.swing.JComboBox();
        slideRevisions = new javax.swing.JSlider();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        mnuViewData.setText("View Revision");
        mnuViewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewDataActionPerformed(evt);
            }
        });

        infoTablePopup.add(mnuViewData);

        mnuViewMRS.setText("View MR");
        mnuViewMRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewMRSActionPerformed(evt);
            }
        });

        infoTablePopup.add(mnuViewMRS);

        setLayout(new java.awt.CardLayout());

        panelInfo.setLayout(new java.awt.BorderLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(getTableModel());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        panelInfo.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton2.setText("View Revision");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.add(jButton2);

        jButton3.setText("View MR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.add(jButton3);

        panelInfo.add(jPanel3, java.awt.BorderLayout.NORTH);

        add(panelInfo, "Info");

        panelView.setLayout(new java.awt.BorderLayout());

        contentBox.setEditable(false);
        contentBox.setFont(ExplorerOptions.getFont());
        scrollArea.setViewportView(contentBox);

        panelView.add(scrollArea, java.awt.BorderLayout.CENTER);

        ControlPane.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(new javax.swing.border.TitledBorder("Information"));
        jLabel1.setText("Date:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        lblDate.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 0);
        jPanel2.add(lblDate, gridBagConstraints);

        jLabel2.setText("Author:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        lblAuthor.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 0);
        jPanel2.add(lblAuthor, gridBagConstraints);

        cboDifferences.setText("Show Differences");
        cboDifferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDifferencesActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        jPanel2.add(cboDifferences, gridBagConstraints);

        ControlPane.add(jPanel2, new java.awt.GridBagConstraints());

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 10, 0));

        jPanel1.setBorder(new javax.swing.border.TitledBorder("Revisions"));
        cmbRevisions.setModel(getRevisions());
        cmbRevisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRevisionsActionPerformed(evt);
            }
        });

        jPanel1.add(cmbRevisions);

        slideRevisions.setSnapToTicks(true);
        slideRevisions.setExtent(1);
        slideRevisions.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slideRevisionsStateChanged(evt);
            }
        });

        jPanel1.add(slideRevisions);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        ControlPane.add(jPanel1, gridBagConstraints);

        panelView.add(ControlPane, java.awt.BorderLayout.SOUTH);

        jButton1.setText("Revisions List");
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uvic/cs/gold/bdickie/icons/backarrow.gif")));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.add(jButton1);

        panelView.add(jPanel4, java.awt.BorderLayout.NORTH);

        add(panelView, "View");

    }//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.mnuViewMRSActionPerformed(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mnuViewDataActionPerformed(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mnuViewMRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewMRSActionPerformed
        FilesTabbedPane.getInstance().openMR((String)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 5));
    }//GEN-LAST:event_mnuViewMRSActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setCard("Info");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboDifferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDifferencesActionPerformed
        updateContent();
    }//GEN-LAST:event_cboDifferencesActionPerformed
    
    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked
    
    private void slideRevisionsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slideRevisionsStateChanged
        setRevision((String)revisions.getElementAt(slideRevisions.getMaximum() - slideRevisions.getValue()));
    }//GEN-LAST:event_slideRevisionsStateChanged
    
    private void mnuViewDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewDataActionPerformed
        if (((Boolean)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4)).booleanValue()) {
            setRevision((String)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0));
            setCard("View");
        }
    }//GEN-LAST:event_mnuViewDataActionPerformed
    
    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
        if (evt.getButton() != evt.BUTTON1) {
            mnuViewData.setEnabled(((Boolean)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4)).booleanValue());
            infoTablePopup.show(jTable1, evt.getX(), evt.getY());
        } else if (evt.getClickCount() == 2) {
            mnuViewDataActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MousePressed
    
    private void cmbRevisionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRevisionsActionPerformed
        setRevision((String)revisions.getSelectedItem());
    }//GEN-LAST:event_cmbRevisionsActionPerformed
    
    /** Sets the current Mode of the pane.
     *  @param desc One of "View" or "Info".
     */
    public void setCard(String desc) {
        ((CardLayout)getLayout()).show(this, desc);
    }
    
    /** Gets the File being shown in this pane.
     */
    public File getFile() {
        return file;
    }
    
    /** Updates the content in the view pane.
     */
    private void updateContent() {
        DBConnection db = DBConnection.getInstance();
        contentBox.setContentType("text/html");
        RevisionDetails details = db.getRevision(file, revision);
        if (details == null) {
            contentBox.setForeground(Color.RED.darker());
            contentBox.setText("Unable to get file contents.");
            ControlPane.setVisible(false);
        } else {
            if (details.isDeleted()) {
                contentBox.setForeground(Color.RED.darker());
                contentBox.setText(file.getFilename() + " Deleted");
            } else {
                contentBox.setForeground(Color.BLACK);
                
                if (this.cboDifferences.isSelected())
                {
                    DiffCalculator diffCalc = new RevisionDiffTable();
                    List l = diffCalc.getDifference(file, revision);
                    contentBox.setText(HTMLizer.generateHTML(l));
                } else
                    contentBox.setText(HTMLizer.generateHTML(details.getContent()));
                contentBox.setCaretPosition(0);
            }
            
            lblAuthor.setText(details.getAuthor());
            lblDate.setText(details.getDate());
        }
    }
    
    /**
     * Getter for property revision.
     * @return Value of property revision.
     */
    public String getRevision() {
        return revision;
    }
    
    /**
     * Setter for property revision.
     * @param revision New value of property revision.
     */
    public void setRevision(String rev) {
        
        if ((revision == null) || !revision.equals(rev)) {
            revision = rev;
            if ((revisions.getSize() > 0) && !revisions.getSelectedItem().equals(revision))
                revisions.setSelectedItem(revision);
            
            int slideIndex = slideRevisions.getMaximum() - revisions.getIndexOf(revision);
            if (slideRevisions.getValue() != slideIndex)
                slideRevisions.setValue(slideIndex);
            
            updateContent();
        }
    }
    
    /** Creates a ComboBoxModel for the viewable revisons.
     */
    private DefaultComboBoxModel getRevisions() {
        revisions = new DefaultComboBoxModel();
        DBConnection db = DBConnection.getInstance();
        List revs = db.getFileRevisions(file);
        
        slideRevisions.setMinimum(1);
        slideRevisions.setMaximum(revs.size());
        
        Iterator i = revs.iterator();
        while(i.hasNext()) {
            revisions.addElement(i.next());
        }
        return revisions;
    }
    
    /** Updates the font being uses in the View display.
     */
    public void updateFont() {
        contentBox.setFont(ExplorerOptions.getFont());
    }
    
    /** Gets the Table model for the Info mode.
     */
    private TableModel getTableModel() {
        NonEditableTableModel result = new NonEditableTableModel(columnNames);
        result.setColumnClass(4, Boolean.class);
        Vector data = DBConnection.getInstance().getRevisions(file);
        Iterator i = data.iterator();
        while(i.hasNext())
            result.addRow((Vector)i.next());
        return result;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPane;
    private javax.swing.JCheckBox cboDifferences;
    private javax.swing.JComboBox cmbRevisions;
    private javax.swing.JEditorPane contentBox;
    private javax.swing.JPopupMenu infoTablePopup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblDate;
    private javax.swing.JMenuItem mnuViewData;
    private javax.swing.JMenuItem mnuViewMRS;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelView;
    private javax.swing.JScrollPane scrollArea;
    private javax.swing.JSlider slideRevisions;
    // End of variables declaration//GEN-END:variables
    
    
    private class InfoTableSelectionChanged implements ListSelectionListener
    {
        public void valueChanged(javax.swing.event.ListSelectionEvent listSelectionEvent) {
            jButton2.setEnabled(((Boolean)jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 4)).booleanValue());
        }
    }
}

/* ChangeLog:
 *   $Log: FileViewPane.java,v $
 *   Revision 1.2  2004/12/07 17:53:22  bdickie
 *   Done Repository Grapher and added GPL boilerplate to older files.
 *
 *   Revision 1.1  2004/11/01 02:24:20  bdickie
 *   Done Repository Browser.
 *
 */

