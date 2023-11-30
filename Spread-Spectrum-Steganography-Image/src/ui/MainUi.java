/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
 
import Controllers.EmbeddingController;
import Controllers.ExtractingController;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class MainUi extends javax.swing.JFrame {

    /**
     * Creates new form Emb
     */
    public MainUi() {
        initComponents();
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputimage_file = new javax.swing.JTextField();
        inputtext_file = new javax.swing.JTextField();
        embbtn = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        key = new javax.swing.JTextField();
        extbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputimage_file.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        inputimage_file.setToolTipText("");
        inputimage_file.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input-Image", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        inputimage_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputimage_fileMouseClicked(evt);
            }
        });

        inputtext_file.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Text-File", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        inputtext_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputtext_fileMouseClicked(evt);
            }
        });

        embbtn.setText("Embedding");
        embbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embbtnActionPerformed(evt);
            }
        });

        image.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        image.setMaximumSize(new java.awt.Dimension(9999, 9999));

        key.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Key", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        extbtn.setText("Extracting");
        extbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputimage_file, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(inputtext_file)
                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(key)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(embbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputimage_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputtext_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(embbtn)
                    .addComponent(extbtn))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void inputimage_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputimage_fileMouseClicked

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Files", "png"));
        fileChooser.setCurrentDirectory(new File("."));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String inputimagefile_path = fileChooser.getSelectedFile().toString();
            inputimage_file.setText(inputimagefile_path);
            ImageIcon ima = new ImageIcon(inputimagefile_path);
            setSize(ima.getIconWidth()+40, ima.getIconHeight()+40);
            setResizable(false);
            image.setIcon(ima);
        } else {
            inputimage_file.setText("");
        }
    }//GEN-LAST:event_inputimage_fileMouseClicked

    
    
    private void inputtext_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputtext_fileMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("TXT Files", "txt"));
        fileChooser.setCurrentDirectory(new File("."));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String inputtextfile_path = fileChooser.getSelectedFile().toString();
            inputtext_file.setText(inputtextfile_path);
        } else {
            inputtext_file.setText("");
        }
    }//GEN-LAST:event_inputtext_fileMouseClicked

    private void embbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_embbtnActionPerformed
        if ( !inputimage_file.getText().isBlank() && !inputtext_file.getText().isBlank() && !key.getText().isBlank() ){
            try {
                String stringoutfile = inputimage_file.getText().replace(".png", " emberdding")+".png";
                Boolean flas =new EmbeddingController( 
                    inputtext_file.getText(), 
                    inputimage_file.getText(),  
                    stringoutfile , 
                    key.getText())
                    .generateStegoImage();
                if (flas){
                    JOptionPane.showMessageDialog(null, "OUTFILE :"+stringoutfile , "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog( null, "Thu lai", "Error", JOptionPane.ERROR_MESSAGE);
                }
                System.out.print(flas );

            } catch (Exception e) {
                JOptionPane.showMessageDialog( null, "Check : File and Key", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog( null, "Error : File and Key not blank", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_embbtnActionPerformed

    private void extbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extbtnActionPerformed
         if ( !inputimage_file.getText().isBlank()  && !key.getText().isBlank() ){
            try {
                String stringoutfile = inputimage_file.getText().replace(".png", " extracting data")+".txt";
                Boolean flag = new ExtractingController(
                    inputimage_file.getText(),
                    stringoutfile,
                    key.getText())
                    .extractMessage();
                if (flag){
                    JOptionPane.showMessageDialog(null, "OUTFILE :"+stringoutfile , "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog( null, "Thu lai", "Error", JOptionPane.ERROR_MESSAGE);
                }
                System.out.print(flag );

            } catch (Exception e) {
                JOptionPane.showMessageDialog( null, "Check : File and Key", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog( null, "Error : File and Key not blank", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_extbtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton embbtn;
    private javax.swing.JButton extbtn;
    private javax.swing.JLabel image;
    private javax.swing.JTextField inputimage_file;
    private javax.swing.JTextField inputtext_file;
    private javax.swing.JTextField key;
    // End of variables declaration//GEN-END:variables
}
