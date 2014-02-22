package windows.persion;

import DBConections.DBCon;
import datas.Persion;
import java.util.List;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.table.DefaultTableModel;
import windows.Selection;

public class ViewAllPerson extends javax.swing.JFrame {
    
    private static final Logger log = LoggerFactory.getLogger(ViewAllPerson.class);

    public ViewAllPerson() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        reloadButton = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Sex", "Address", "TPNum", "Birth Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTable);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("All Details");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        reloadButton.setText("View All Person");
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(reloadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(reloadButton)
                    .addComponent(btnHome)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed

       

        List<Persion> persionList = null;
        try {
            persionList = new DBCon().getAllPerson();
        } catch (Exception ex) {
            log.error("Error... "+ex);
            JOptionPane.showMessageDialog(this, "Error DB");
        }
        DefaultTableModel dtm = (DefaultTableModel) customerTable.getModel();
        dtm.setRowCount(0);
        for (Persion pers : persionList) {
            Object rowData[] = {pers.getName(), pers.getId(), pers.getSex(), pers.getAddress(), pers.getTpnum(), pers.getBirthday(),pers.getHomeNumber()};
            dtm.addRow(rowData);
        }
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        new Selection().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Selection serchpersion = new Selection();
        serchpersion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = customerTable.getSelectedRow();
        int selectedColumnIndex = 1;
        String selectedid = (String) customerTable.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
        try {
            Persion pers=new DBCon().searchPersons(selectedid);
            new Preson(this,true,pers).setVisible(true);
            //this.dispose();
        } catch (Exception ex) {
            log.error("Error... "+ex);
            JOptionPane.showMessageDialog(this, "Error");
        }  
    }//GEN-LAST:event_customerTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHome;
    private javax.swing.JTable customerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reloadButton;
    // End of variables declaration//GEN-END:variables
}
