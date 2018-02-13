/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author student
 */
public class MainWindow extends javax.swing.JFrame {
    
    private File soubor;
    private String kodovani = "UTF-8";
    private final Soubor txtSoubor = new Soubor();
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ToolBar = new javax.swing.JToolBar();
        itemNewFile = new javax.swing.JButton();
        itemOpenFile = new javax.swing.JButton();
        itemSaveFile = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textEditor = new javax.swing.JEditorPane();
        MenuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuNewFile = new javax.swing.JMenuItem();
        menuOpenFile = new javax.swing.JMenuItem();
        menuSaveFile = new javax.swing.JMenuItem();
        menuSaveFileAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuFileInfo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuCut = new javax.swing.JMenuItem();
        menuCopy = new javax.swing.JMenuItem();
        menuPaste = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuFind = new javax.swing.JMenuItem();
        menuReplace = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuSelectAll = new javax.swing.JMenuItem();
        menuSettings = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        menuToolBarEnabled = new javax.swing.JCheckBoxMenuItem();
        menuStatusPanelEnabled = new javax.swing.JCheckBoxMenuItem();
        menuBackgroundColor = new javax.swing.JMenuItem();
        menuFont = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCPUTF8 = new javax.swing.JRadioButtonMenuItem();
        menuCPWindows1250 = new javax.swing.JRadioButtonMenuItem();
        menuCpISO88592 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editorek");

        ToolBar.setRollover(true);

        itemNewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/ikony/new.png"))); // NOI18N
        itemNewFile.setText("New File");
        itemNewFile.setFocusable(false);
        itemNewFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        itemNewFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(itemNewFile);

        itemOpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/ikony/open.png"))); // NOI18N
        itemOpenFile.setText("Open file");
        itemOpenFile.setFocusable(false);
        itemOpenFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        itemOpenFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        itemOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOpenFileActionPerformed(evt);
            }
        });
        ToolBar.add(itemOpenFile);

        itemSaveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/ikony/save.png"))); // NOI18N
        itemSaveFile.setText("Save file");
        itemSaveFile.setFocusable(false);
        itemSaveFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        itemSaveFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        itemSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSaveFileActionPerformed(evt);
            }
        });
        ToolBar.add(itemSaveFile);

        statusPanel.setLayout(new java.awt.GridLayout(1, 3));

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("jLabel2");
        statusPanel.add(jLabel2);

        jLabel1.setBackground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("jLabel1");
        statusPanel.add(jLabel1);

        jLabel3.setBackground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("jLabel3");
        statusPanel.add(jLabel3);

        jScrollPane2.setViewportView(textEditor);

        menuFile.setText("File");

        menuNewFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/ikony/new-small.png"))); // NOI18N
        menuNewFile.setText("New file");
        menuFile.add(menuNewFile);

        menuOpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/ikony/open-small.png"))); // NOI18N
        menuOpenFile.setText("Open file");
        menuFile.add(menuOpenFile);

        menuSaveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSaveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/ikony/save-small.png"))); // NOI18N
        menuSaveFile.setText("Save file");
        menuFile.add(menuSaveFile);

        menuSaveFileAs.setText("Save file as...");
        menuSaveFileAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveFileAsActionPerformed(evt);
            }
        });
        menuFile.add(menuSaveFileAs);
        menuFile.add(jSeparator1);

        menuFileInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuFileInfo.setText("File info");
        menuFile.add(menuFileInfo);
        menuFile.add(jSeparator2);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuExit.setText("Exit");
        menuFile.add(menuExit);

        MenuBar.add(menuFile);

        menuEdit.setText("Edit");

        menuCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuCut.setText("Cut");
        menuEdit.add(menuCut);

        menuCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuCopy.setText("Copy");
        menuEdit.add(menuCopy);

        menuPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuPaste.setText("Paste");
        menuEdit.add(menuPaste);
        menuEdit.add(jSeparator3);

        menuFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuFind.setText("Find");
        menuEdit.add(menuFind);

        menuReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuReplace.setText("Replace");
        menuEdit.add(menuReplace);
        menuEdit.add(jSeparator4);

        menuSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuSelectAll.setText("Select all");
        menuEdit.add(menuSelectAll);

        MenuBar.add(menuEdit);

        menuSettings.setText("Settings");

        jMenu1.setText("Display");

        menuToolBarEnabled.setSelected(true);
        menuToolBarEnabled.setText("Tool bar");
        menuToolBarEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuToolBarEnabledActionPerformed(evt);
            }
        });
        jMenu1.add(menuToolBarEnabled);

        menuStatusPanelEnabled.setSelected(true);
        menuStatusPanelEnabled.setText("Status bar");
        menuStatusPanelEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStatusPanelEnabledActionPerformed(evt);
            }
        });
        jMenu1.add(menuStatusPanelEnabled);

        menuSettings.add(jMenu1);

        menuBackgroundColor.setText("Background colour");
        menuBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBackgroundColorActionPerformed(evt);
            }
        });
        menuSettings.add(menuBackgroundColor);

        menuFont.setText("Font");
        menuSettings.add(menuFont);

        jMenu2.setText("Code page");

        buttonGroup1.add(menuCPUTF8);
        menuCPUTF8.setSelected(true);
        menuCPUTF8.setText("UTF-8");
        jMenu2.add(menuCPUTF8);

        buttonGroup1.add(menuCPWindows1250);
        menuCPWindows1250.setText("Windows 1250");
        jMenu2.add(menuCPWindows1250);

        buttonGroup1.add(menuCpISO88592);
        menuCpISO88592.setText("ISO-8859-2");
        jMenu2.add(menuCpISO88592);

        menuSettings.add(jMenu2);

        MenuBar.add(menuSettings);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuToolBarEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuToolBarEnabledActionPerformed
        ToolBar.setVisible(menuToolBarEnabled.isSelected());
    }//GEN-LAST:event_menuToolBarEnabledActionPerformed

    private void menuStatusPanelEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStatusPanelEnabledActionPerformed
        statusPanel.setVisible(menuStatusPanelEnabled.isSelected());
    }//GEN-LAST:event_menuStatusPanelEnabledActionPerformed

    private void menuBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBackgroundColorActionPerformed
        textEditor.setBackground(JColorChooser.showDialog(this, "Select background colour", textEditor.getBackground()));
    }//GEN-LAST:event_menuBackgroundColorActionPerformed

    private void itemOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOpenFileActionPerformed
        try{
            JFileChooser fc = new JFileChooser();
            fc.setDialogType(JFileChooser.OPEN_DIALOG);
            fc.setDialogTitle("Otevření souboru");
            fc.setCurrentDirectory(new java.io.File("."));
            FileNameExtensionFilter myFilter = new FileNameExtensionFilter("Text","txt");
            fc.setFileFilter(myFilter);
            if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                soubor = fc.getSelectedFile();
                try{
                    txtSoubor.nactiZeSouboru(soubor,kodovani);
                    textEditor.setText(txtSoubor.getData());
                }catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(this,"Požadovaný soubor nebyl nalezen!","Chyba!",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Nastala chby při otevření souboru!","Chyba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemOpenFileActionPerformed

    private void itemSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaveFileActionPerformed
        if(soubor!= null){
            try{
                txtSoubor.ulozDoSouboru(soubor, kodovani,textEditor.getText());
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(this,"Požadovaný soubor nebyl nalezen!","Chyba!",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            menuSaveFileAsActionPerformed(evt);
    }//GEN-LAST:event_itemSaveFileActionPerformed

    private void menuSaveFileAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveFileAsActionPerformed
        try{    
            JFileChooser fc = new JFileChooser();
            fc.setDialogType(JFileChooser.OPEN_DIALOG);
            fc.setDialogTitle("Otevření souboru");
            fc.setCurrentDirectory(new java.io.File("."));
            FileNameExtensionFilter myFilter = new FileNameExtensionFilter("Text","txt");
            fc.setFileFilter(myFilter);
            if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                soubor = fc.getSelectedFile();
                try{
                    txtSoubor.ulozDoSouboru(soubor, kodovani,textEditor.getText());
                }catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(this,"Požadovaný soubor nebyl nalezen!","Chyba!",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Nastala chby při otevření souboru!","Chyba!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuSaveFileAsActionPerformed
    
    private String informaceOSouboru(){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton itemNewFile;
    private javax.swing.JButton itemOpenFile;
    private javax.swing.JButton itemSaveFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem menuBackgroundColor;
    private javax.swing.JRadioButtonMenuItem menuCPUTF8;
    private javax.swing.JRadioButtonMenuItem menuCPWindows1250;
    private javax.swing.JMenuItem menuCopy;
    private javax.swing.JRadioButtonMenuItem menuCpISO88592;
    private javax.swing.JMenuItem menuCut;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFileInfo;
    private javax.swing.JMenuItem menuFind;
    private javax.swing.JMenuItem menuFont;
    private javax.swing.JMenuItem menuNewFile;
    private javax.swing.JMenuItem menuOpenFile;
    private javax.swing.JMenuItem menuPaste;
    private javax.swing.JMenuItem menuReplace;
    private javax.swing.JMenuItem menuSaveFile;
    private javax.swing.JMenuItem menuSaveFileAs;
    private javax.swing.JMenuItem menuSelectAll;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JCheckBoxMenuItem menuStatusPanelEnabled;
    private javax.swing.JCheckBoxMenuItem menuToolBarEnabled;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JEditorPane textEditor;
    // End of variables declaration//GEN-END:variables
}
