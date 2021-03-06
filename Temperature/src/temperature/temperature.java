/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Vikto
 */
public class temperature extends javax.swing.JFrame {

    /**
     * Creates new form temperature
     */
    private class TempInfo{
        public double zeroPoint;
        public double increment;
        public JLabel label;
        public JRadioButton button;
        
        public TempInfo(double a,double b,JLabel c,JRadioButton d){
            this.zeroPoint = a;
            this.increment = b;
            this.label = c;
            this.button = d;
        }
        
        public void update(double a,double b){
            this.zeroPoint = a;
            this.increment = b;
        }
    }
    
    private TempInfo celsius;
    private TempInfo fahrenheit;
    private TempInfo kelvin;
    private TempInfo custom;
    
    private TempInfo[] temperatures = new TempInfo[4];
    
    public temperature() {
        initComponents();
        celsius = new TempInfo(273.15,1,labCel,butCel);
        temperatures[0] = celsius;
        fahrenheit = new TempInfo(255.372222, 5.0/9.0,labFar,butFar);
        temperatures[1] = fahrenheit;
        kelvin = new TempInfo(0,1,labKel,butKel);
        temperatures[2] = kelvin;
        custom = new TempInfo(0,0,labCus,butCus);
        temperatures[3] = custom;
       
        updateCustom();
    }
    
    private void updateCustom(){
        custom.update((double)spinnerZeroPoint.getValue(),(double)spinnerIncrement.getValue());
        //JOptionPane.showMessageDialog(null,"Hodnota zero:"+(double)(int)sliderZeroPoint.getValue()+"\nHodnota step: "+(double)(int)sliderIncrement.getValue());
    }
    
    private void updateValues(){
        TempInfo selected = null;
        for (TempInfo active : temperatures){
            if (active.button.isSelected())
                selected = active;
            //JOptionPane.showMessageDialog(null,active.zeroPoint);
        }
        if (selected == null) return;
        for (TempInfo active : temperatures){
            active.label.setText(String.format("%.2f",convertTemp(jSlider1.getValue(),selected,active)));
        }
    }
    
    private double convertTemp(int input,TempInfo in,TempInfo out){
        return ((in.zeroPoint+input*in.increment)-out.zeroPoint)/out.increment;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        temperatureSelection = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        butCel = new javax.swing.JRadioButton();
        butFar = new javax.swing.JRadioButton();
        butKel = new javax.swing.JRadioButton();
        butCus = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labCel = new javax.swing.JLabel();
        labFar = new javax.swing.JLabel();
        labKel = new javax.swing.JLabel();
        labCus = new javax.swing.JLabel();
        spinnerZeroPoint = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        spinnerIncrement = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Ukončit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("verze 0.1");

        jButton2.setText("O");
        jButton2.setEnabled(false);

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(50);
        jSlider1.setMinimum(-50);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(0);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });
        jSlider1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jSlider1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        temperatureSelection.add(butCel);
        butCel.setText("Celsius");
        butCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCelActionPerformed(evt);
            }
        });

        temperatureSelection.add(butFar);
        butFar.setText("Fahrenheit");

        temperatureSelection.add(butKel);
        butKel.setText("Kelvin");

        temperatureSelection.add(butCus);
        butCus.setText("Dle vlastní definice");

        jLabel2.setText("Celsius");

        jLabel3.setText("Fahrenheit");

        jLabel4.setText("Kelvin");

        jLabel5.setText("Vlastní");

        labCel.setText("jLabel2");

        labFar.setText("jLabel3");

        labKel.setText("jLabel4");

        labCus.setText("jLabel5");

        spinnerZeroPoint.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.01d));
        spinnerZeroPoint.setToolTipText("Zadejte kolik Kelvinů je 0 jednotek Vaši stupnice.");
        spinnerZeroPoint.setDoubleBuffered(true);
        spinnerZeroPoint.setName(""); // NOI18N
        spinnerZeroPoint.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerZeroPointStateChanged(evt);
            }
        });

        jLabel6.setText("Nulový bod:");

        spinnerIncrement.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.01d, null, 0.01d));
        spinnerIncrement.setToolTipText("Zadejte o kolik se zvětší teplota ve Vaši jednotce při zvýšení teploty o 1 Kelvin.");
        spinnerIncrement.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIncrementStateChanged(evt);
            }
        });

        jLabel7.setText("Krok:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butCel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butFar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butKel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butCus))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labFar)
                                            .addComponent(labKel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labCel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinnerZeroPoint)
                                    .addComponent(spinnerIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labCus)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerZeroPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butCel)
                            .addComponent(butFar)
                            .addComponent(butKel)
                            .addComponent(butCus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labCel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labFar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labKel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labCus)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSlider1CaretPositionChanged

    }//GEN-LAST:event_jSlider1CaretPositionChanged

    private void butCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butCelActionPerformed

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
        updateValues();
    }//GEN-LAST:event_jSlider1MouseDragged

    private void spinnerZeroPointStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerZeroPointStateChanged
        updateCustom();
        updateValues();
    }//GEN-LAST:event_spinnerZeroPointStateChanged

    private void spinnerIncrementStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerIncrementStateChanged
        updateCustom();
        updateValues();
    }//GEN-LAST:event_spinnerIncrementStateChanged

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(temperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(temperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(temperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(temperature.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new temperature().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton butCel;
    private javax.swing.JRadioButton butCus;
    private javax.swing.JRadioButton butFar;
    private javax.swing.JRadioButton butKel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel labCel;
    private javax.swing.JLabel labCus;
    private javax.swing.JLabel labFar;
    private javax.swing.JLabel labKel;
    private javax.swing.JSpinner spinnerIncrement;
    private javax.swing.JSpinner spinnerZeroPoint;
    private javax.swing.ButtonGroup temperatureSelection;
    // End of variables declaration//GEN-END:variables
}
