/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package windows.persion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import DBConections.DBCon;
import datas.Persion;
import javax.swing.JOptionPane;

public class Preson extends javax.swing.JDialog {

    private static final Logger log = LoggerFactory.getLogger(Preson.class);

    public Preson(java.awt.Frame parent, boolean modal, Persion pers) {
        super(parent, modal);
        initComponents();
        TFID.setText(pers.getId());
        TFName.setText(pers.getName());
        TFSex.setText(pers.getSex());
        TFAddress.setText(pers.getAddress());
        TFTPNumber.setText(pers.getTpnum());
        TFbirthdate.setText(pers.getBirthday());
        TFhomeNumber.setText(pers.getHomeNumber());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        TFhomeNumber = new javax.swing.JTextField();
        TFID = new javax.swing.JTextField();
        TFAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TFSex = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TFTPNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TFName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFbirthdate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("TP NUm");

        TFAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFAddressActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Name");

        TFSex.setEditable(false);
        TFSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFSexActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("Home Number");

        TFTPNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFTPNumberActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Birth Date");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("ID num");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Sex");

        TFbirthdate.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Address");

        btnEdit.setText("Edited and Save");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setText("Persion Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(101, 101, 101)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFSex, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFName, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(93, 93, 93)
                                    .addComponent(TFAddress)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TFbirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(95, 95, 95)
                                    .addComponent(TFTPNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TFhomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFTPNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFbirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TFhomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnBack))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TFSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFSexActionPerformed

    }//GEN-LAST:event_TFSexActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            DBCon db = new DBCon();
            Persion persion = new Persion();

            persion.setId(TFID.getText());
            if (TFID.getText().isEmpty() && (persion.getId()).length() != 10) {
                JOptionPane.showMessageDialog(this, "ID number should contain 10 charactor");
            } else {
                persion.setName(TFName.getText());
                persion.setSex(TFSex.getText());
                persion.setBirthday(TFbirthdate.getText());
                persion.setAddress(TFAddress.getText());
                persion.setTpnum(TFTPNumber.getText());
                persion.setHomeNumber(TFhomeNumber.getText());

                if (persion.getName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name can not be empty");
                } else if (persion.getAddress().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Enter the address");
                } else if (persion.getHomeNumber().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Enter the Home Number");
                } else {
                    db.updatePersionData(persion);
                    JOptionPane.showMessageDialog(this, "Updated ...");
                }
            }
        } catch (Exception ex) {
            log.error("Error " + ex);
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int selectedOption = JOptionPane.showConfirmDialog(null,
                "Do you want to delete theis Persion?",
                "Choose",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION) {
            try {
                DBCon db = new DBCon();
                String id = TFID.getText();
                System.out.println("id :" + id);
                db.deletePersionData(id);
                JOptionPane.showMessageDialog(this, "Deleted ...");
                TFID.setText("");
                TFName.setText("");
                TFSex.setText("");
                TFAddress.setText("");
                TFTPNumber.setText("");
                TFbirthdate.setText("");
                TFhomeNumber.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error... Can not delete");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new SerchPersion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void TFTPNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFTPNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFTPNumberActionPerformed

    private void TFAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFAddressActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFAddress;
    private javax.swing.JTextField TFID;
    private javax.swing.JTextField TFName;
    private javax.swing.JTextField TFSex;
    private javax.swing.JTextField TFTPNumber;
    private javax.swing.JTextField TFbirthdate;
    private javax.swing.JTextField TFhomeNumber;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
