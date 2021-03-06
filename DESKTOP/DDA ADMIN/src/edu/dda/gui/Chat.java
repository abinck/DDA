/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.gui;

import edu.dda.models.ChatHistoryModel;
import edu.dda.models.EmpDetailsModel;
import edu.dda.nw.client.ChatClient;
import edu.dda.nw.client.DDAClient;
import edu.dda.utils.Variables;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pvr
 */
public class Chat extends javax.swing.JInternalFrame {

    /**
     * Creates new form Chat
     */
    ArrayList<EmpDetailsModel> empDetailsModels = null;
    ChatClient cc = null;
    static DefaultTableModel tableModel = null;
    static ArrayList<ChatHistoryModel> historyModels = null;

    public Chat() {
        initComponents();
        initGUI();
        initTable();
        cc = Variables.chatClient;
    }

    private void initGUI() {
        empDetailsModels = DDAClient.getAllOnlineEmpDetails();
        if (!"[]".equals(empDetailsModels)) {
            Vector<String> empVector = new Vector<>();
            for (EmpDetailsModel edm : empDetailsModels) {
                empVector.add(edm.getFname() + " " + edm.getLname());
            }
            onlineEmpList.setListData(empVector);
        }
    }

    private static void initTable() {
        tableModel = new DefaultTableModel(new String[]{"SL NO", "FROM ID", "TO ID", "FROM UTYPE", "TO UTYPE", "MESSAGE", "SEND DATE", "SEND TIME"}, 0);
        historyModels = DDAClient.getAllChatHistory();
        int count = 0;
        for (ChatHistoryModel chm : historyModels) {
            count++;
            tableModel.addRow(new String[]{count + "", chm.getFromId() + "", chm.getToId() + "", chm.getFromUtype(), chm.getToUtype(), chm.getMsg(), chm.getCtDate(), chm.getCtTime()});
        }
        historyTB.setModel(tableModel);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineEmpList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        toEmpLB = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyTA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        typeTA = new javax.swing.JTextArea();
        sendBT = new javax.swing.JButton();
        clearBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        historyTB = new javax.swing.JTable();
        clearChatHistoryBT = new javax.swing.JButton();

        setClosable(true);
        setTitle("CHAT");

        onlineEmpList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onlineEmpListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(onlineEmpList);

        jLabel1.setText("Online Employees");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel2.setText("TO");

        historyTA.setEditable(false);
        historyTA.setColumns(20);
        historyTA.setRows(5);
        jScrollPane2.setViewportView(historyTA);

        typeTA.setColumns(20);
        typeTA.setRows(5);
        jScrollPane3.setViewportView(typeTA);

        sendBT.setText("Send");
        sendBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBTActionPerformed(evt);
            }
        });

        clearBT.setText("Clear");
        clearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(clearBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendBT))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(toEmpLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toEmpLB, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBT)
                    .addComponent(sendBT))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chat", jPanel3);

        historyTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(historyTB);

        clearChatHistoryBT.setText("Clear Chat History");
        clearChatHistoryBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearChatHistoryBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(clearChatHistoryBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(clearChatHistoryBT)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Chat History", jPanel2);

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

    private void onlineEmpListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onlineEmpListValueChanged
        int position = onlineEmpList.getSelectedIndex();
        String name = empDetailsModels.get(position).getFname() + " " + empDetailsModels.get(position).getLname();
        toEmpLB.setText(name);
    }//GEN-LAST:event_onlineEmpListValueChanged

    private void clearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTActionPerformed
        clear();
    }//GEN-LAST:event_clearBTActionPerformed

    private void sendBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBTActionPerformed
        int position = onlineEmpList.getSelectedIndex();
        if (position >= 0) {
            String toEmail = empDetailsModels.get(position).getLoginModel().getEmail();
            String msg = typeTA.getText();
            int toId = empDetailsModels.get(position).getId();
            cc.sender.sendToOne(toEmail, msg);
            clear();
            boolean result = DDAClient.addChatHistory(0, toId, "admin", "emp", msg);
            if (result) {
                initTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Must select a user", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_sendBTActionPerformed

    private void clearChatHistoryBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearChatHistoryBTActionPerformed
        boolean result = DDAClient.clearChatHistory();
        if (result) {
            initTable();
            writeToConsole("Chat history cleared");
        } else {
            writeToConsole("Failed To Clear Chat history");
        }
    }//GEN-LAST:event_clearChatHistoryBTActionPerformed
    private void clear() {
        typeTA.setText(null);
    }

    public static void updateMSG(String msg) {
        historyTA.append(msg + "\n");
        initTable();
    }

    public static void writeToConsole(String msg) {
        AdminHome.writeToConsole(msg);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBT;
    private javax.swing.JButton clearChatHistoryBT;
    private static javax.swing.JTextArea historyTA;
    private static javax.swing.JTable historyTB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList onlineEmpList;
    private javax.swing.JButton sendBT;
    private javax.swing.JLabel toEmpLB;
    private javax.swing.JTextArea typeTA;
    // End of variables declaration//GEN-END:variables
}
