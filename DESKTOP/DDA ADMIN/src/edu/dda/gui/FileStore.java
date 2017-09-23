/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.gui;

import edu.dda.models.DepartmentModel;
import edu.dda.models.FileStoreModel;
import edu.dda.nw.client.DDAClient;
import edu.dda.nw.client.FileClient;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pvr
 */
public class FileStore extends javax.swing.JInternalFrame {

    /**
     * Creates new form FileStore
     */
    ArrayList<DepartmentModel> departmentModels = null;
    ArrayList<FileStoreModel> fileStoreModels = null;
    DefaultTableModel defaultTableModel = null;

    public FileStore() {
        initComponents();
        initGUI();
        initTable();
    }

    private void initGUI() {
        departmentModels = DDAClient.getAllDept();
        for (DepartmentModel dm : departmentModels) {
            deptCB.addItem(dm.getDeptName());
        }
    }

    private void initTable() {
        int count = 1;
        defaultTableModel = new DefaultTableModel(new String[]{"SL NO", "FILE NAME", "FILE SIZE", "UPLOAD DATE", "UPLOAD TIME", "DEPT ID"}, 0);
        fileStoreModels = DDAClient.getAllFiles();
        for (FileStoreModel fsm : fileStoreModels) {
            defaultTableModel.addRow(new String[]{"" + count++, fsm.getFileName(), fsm.getFileSize(), fsm.getUpDate(), fsm.getUpTime(), fsm.getDeptMapModel().getDeptId() + ""});
        }
        fileStoreTB.setModel(defaultTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filePathTF = new javax.swing.JTextField();
        chooseBT = new javax.swing.JButton();
        deptCB = new javax.swing.JComboBox();
        uploadBT = new javax.swing.JButton();
        resetBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileStoreTB = new javax.swing.JTable();
        deleteBT = new javax.swing.JButton();

        setClosable(true);
        setTitle("File Store");

        jLabel1.setText("Department");

        jLabel2.setText("File");

        chooseBT.setText("Choose File");
        chooseBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseBTActionPerformed(evt);
            }
        });

        deptCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECT DEPARTMENT--" }));

        uploadBT.setText("UPLOAD");
        uploadBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBTActionPerformed(evt);
            }
        });

        resetBT.setText("RESET");
        resetBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(uploadBT)
                        .addGap(139, 139, 139)
                        .addComponent(resetBT))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(filePathTF)
                        .addComponent(deptCB, 0, 278, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(chooseBT, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deptCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(filePathTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseBT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadBT)
                    .addComponent(resetBT))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("UPLOAD", jPanel1);

        fileStoreTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(fileStoreTB);

        deleteBT.setText("Delete");
        deleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(deleteBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(deleteBT)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("MANAGE", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseBTActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        filePathTF.setText(fileChooser.getSelectedFile().getPath());

    }//GEN-LAST:event_chooseBTActionPerformed

    private void resetBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBTActionPerformed
        reset();
    }//GEN-LAST:event_resetBTActionPerformed

    private void uploadBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBTActionPerformed
        String filePath = filePathTF.getText();
        int position = deptCB.getSelectedIndex();
        if (position < 1) {
            deptCB.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Select Department", "WARNING", JOptionPane.WARNING_MESSAGE);

        } else if ("".equals(filePath)) {
            filePathTF.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Choose A File", "WARNING", JOptionPane.WARNING_MESSAGE);

        } else {
            int deptId = departmentModels.get(position - 1).getId();
            boolean result = FileClient.uploadFile(deptId, filePath);
            if (result) {
                reset();
                initTable();
                writeToConsole("File uploaded");
            } else {
                writeToConsole("Failed to upload");
            }
        }

    }//GEN-LAST:event_uploadBTActionPerformed

    private void deleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTActionPerformed
        int rowPos = fileStoreTB.getSelectedRow();
        if (rowPos >= 0) {
            int fileId = fileStoreModels.get(rowPos).getId();
            System.out.println("fileId = " + fileId);
            int deptId = fileStoreModels.get(rowPos).getDeptMapModel().getDeptId();
            String fileName = fileStoreModels.get(rowPos).getFileName();
            boolean result = DDAClient.deleteFile(fileId, fileName, deptId);
            if (result) {
                writeToConsole("File deleted");
                initTable();
            } else {
                writeToConsole("Failed to delete");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Must select a row", "SELECT WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBTActionPerformed

    private void reset() {
        deptCB.setSelectedIndex(0);
        filePathTF.setText(null);
        deptCB.setBorder(BorderFactory.createLineBorder(null));
        filePathTF.setBorder(BorderFactory.createLineBorder(null));
    }

    public static void writeToConsole(String msg) {
        AdminHome.writeToConsole(msg);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseBT;
    private javax.swing.JButton deleteBT;
    private javax.swing.JComboBox deptCB;
    private javax.swing.JTextField filePathTF;
    private javax.swing.JTable fileStoreTB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton resetBT;
    private javax.swing.JButton uploadBT;
    // End of variables declaration//GEN-END:variables
}
