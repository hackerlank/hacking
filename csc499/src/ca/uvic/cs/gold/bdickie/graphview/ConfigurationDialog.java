/*
 * $Id: ConfigurationDialog.java,v 1.1 2004/12/07 17:53:23 bdickie Exp $
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

package ca.uvic.cs.gold.bdickie.graphview;

import javax.swing.JFrame;
import say.swing.JFontChooser;
import ca.uvic.cs.gold.bdickie.db.DBSelectionPanel;

/** The options dialogs for setting up the repository grapher.
 *
 * @author  Blake Dickie
 */
public class ConfigurationDialog extends javax.swing.JDialog {
    DBSelectionPanel panDBSelection;
    
    /** Creates new form ConfigurationDialog */
    public ConfigurationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fontChooser = new JFontChooser();
        fontChooser.setSelectedFont(GraphViewOptions.getFont());
        panFont.add(fontChooser);
        
        panDBSelection = new DBSelectionPanel();
        panDB.add(panDBSelection);
        pack();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        tabs = new javax.swing.JTabbedPane();
        panMainOptions = new javax.swing.JPanel();
        panDB = new javax.swing.JPanel();
        panFont = new javax.swing.JPanel();
        panButtons = new javax.swing.JPanel();
        butSave = new javax.swing.JButton();

        setTitle("Repository Browser Configuration");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panMainOptions.setLayout(new java.awt.GridBagLayout());

        panDB.setBorder(new javax.swing.border.TitledBorder("Database"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        panMainOptions.add(panDB, gridBagConstraints);

        tabs.addTab("General", panMainOptions);

        tabs.addTab("Font", panFont);

        getContentPane().add(tabs, java.awt.BorderLayout.CENTER);

        butSave.setMnemonic('s');
        butSave.setText("Save");
        butSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSaveActionPerformed(evt);
            }
        });

        panButtons.add(butSave);

        getContentPane().add(panButtons, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void butSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveActionPerformed
        panDBSelection.closing();
        GraphViewOptions.setFont(fontChooser.getSelectedFont());
        GraphViewOptions.saveSettings();
        hide();
    }//GEN-LAST:event_butSaveActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butSave;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panDB;
    private javax.swing.JPanel panFont;
    private javax.swing.JPanel panMainOptions;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
    private JFontChooser fontChooser;
    
    /* Shows the settings dialog ontop of the given frame.
     */
    public static void show(JFrame frame)
    {
        new ConfigurationDialog(frame, true).show();
    }
    
    /* Shows the settings dialog without a parent frame.
     */
    public static void showParentless()
    {
        JFrame f = new JFrame();
        show(f);
        f.dispose();
    }
}

/* ChangeLog:
 *   $Log: ConfigurationDialog.java,v $
 *   Revision 1.1  2004/12/07 17:53:23  bdickie
 *   Done Repository Grapher and added GPL boilerplate to older files.
 *
 */
