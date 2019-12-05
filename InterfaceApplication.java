
import java.io.File;
import javax.swing.JFileChooser;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JScrollPane;

/**
 *
 * @author Vir
 */
public class InterfaceApplication extends javax.swing.JFrame  {
    
    private String formattedString = "", errorString = "";  //use super to change the strings 
    private boolean errors = false; //if there is an error, change this to true
    
    /**
     * Creates new form InterfaceApplication
     */
    public InterfaceApplication() {
        initComponents();
    }
    //CSE360Project obj =new CSE360Project();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConsoleField = new javax.swing.JTextArea();
        ErrorLogField = new javax.swing.JTextArea();
        ConsoleScrollPane = new javax.swing.JScrollPane(ConsoleField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ErrorLogScrollPane = new javax.swing.JScrollPane(ErrorLogField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LoadFileButton = new javax.swing.JLabel();
        ResetButton = new javax.swing.JButton();
        FilePathField = new javax.swing.JTextField();
        ChooseFile = new javax.swing.JButton();
        SaveFileButton = new javax.swing.JButton();
        PreviewButton = new javax.swing.JButton();



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        /*
        ConsoleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsoleFieldActionPerformed(evt);
            }
        });

        ErrorLogField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ErrorLogFieldActionPerformed(evt);
            }
        });
        */

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setText("Text Parser Program");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Console");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Error Log");

        LoadFileButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LoadFileButton.setText("Load File");

        ResetButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ResetButton.setText("Reset");
        ResetButton.setActionCommand("Save File");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        FilePathField.setEditable(false);
        FilePathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilePathFieldActionPerformed(evt);
            }
        });

        ChooseFile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ChooseFile.setText("Choose File");
        ChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFileActionPerformed(evt);
            }
        });

        SaveFileButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SaveFileButton.setText("Save File");
        SaveFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileButtonActionPerformed(evt);
            }
        });

        PreviewButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PreviewButton.setText("Preview");
        PreviewButton.setActionCommand("Save File");
        PreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(SaveFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PreviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LoadFileButton)
                                .addGap(18, 18, 18)
                                .addComponent(FilePathField, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(ConsoleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(334, 334, 334)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ErrorLogScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(79, 79, 79))))
                    .addComponent(ChooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilePathField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadFileButton)
                    .addComponent(ChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConsoleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ErrorLogScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsoleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsoleFieldActionPerformed
        // TODO add your handling code here:
        //------------------------------Console window
        
    }//GEN-LAST:event_ConsoleFieldActionPerformed
    
    private void ErrorLogFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ErrorLogFieldActionPerformed
        // TODO add your handling code here:
        //-------------------------------Error Log
    }//GEN-LAST:event_ErrorLogFieldActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        //-----------------------------Reset Button--------------------------
        FilePathField.setText("");    //File path clear
        ConsoleField.setText("");    //Console clear
        ErrorLogField.setText("");    //Error log clear
        formattedString = "";
        errorString = "";
        errors = false;
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void FilePathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilePathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilePathFieldActionPerformed

    private void ChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFileActionPerformed
        // TODO add your handling code here:
        //-----------------------------------Choose File button
         JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName = file.getAbsolutePath();
        FilePathField.setText(fileName);
        InitialCleaner cleanFile = new InitialCleaner(fileName);
        cleanFile.clean_input();
        //String testStr = cleanFile.Test_Inheritance();
        //this.Console_Write(testStr);
    }//GEN-LAST:event_ChooseFileActionPerformed

    private void SaveFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileButtonActionPerformed
        // TODO add your handling code here:
        //---------------------------------Save File button
    }//GEN-LAST:event_SaveFileButtonActionPerformed

    private void PreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewButtonActionPerformed
        // TODO add your handling code here:
        //-----------------------------------Preview Button
        if(errors == true){
            ErrorLogField.setText(errorString);
        }
        else{
            ConsoleField.setText(formattedString);
        }
    }//GEN-LAST:event_PreviewButtonActionPerformed


    public void Console_Write(String toWrite){
        System.out.println("CHECKSUM");
        ConsoleField.setText(toWrite);
    }

    public void ErrorLog_Write(String errorMsg){
        System.out.println("CHECKSUM");
        ErrorLogField.setText(ErrorLogField.getText() + errorMsg);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseFile;
    private javax.swing.JTextArea ConsoleField;
    private javax.swing.JTextArea ErrorLogField;
    private javax.swing.JTextField FilePathField;
    private javax.swing.JScrollPane ErrorLogScrollPane;
    private javax.swing.JScrollPane ConsoleScrollPane;
    private javax.swing.JLabel LoadFileButton;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveFileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}