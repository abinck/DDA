/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.gui;

import edu.dda.nw.client.ChatClient;
import edu.dda.nw.server.RequestServer;
import edu.dda.utils.CheckPortAvailability;
import edu.dda.utils.Variables;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author pvr
 */
public class AdminHome extends javax.swing.JFrame {

    /**
     * Creates new form AdminHome
     */
    Department department = null;
    Employee employee = null;
    Notification notification = null;
    FileStore fileStore = null;
    ScheduleCapture capture = null;
    Chat chat = null;
    RequestServer requestServer = null;

    public AdminHome() {

        initComponents();
        fullScreen(this);
        ChatClient cc = new ChatClient("admin", chat);
        Variables.chatClient = cc;
    }

    public final void fullScreen(JFrame frmMain) {
        double width, height, x, y;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Insets bounds = Toolkit.getDefaultToolkit().getScreenInsets(frmMain.getGraphicsConfiguration());

        width = screenSize.getWidth() - bounds.left - bounds.right;
        height = screenSize.getHeight() - bounds.top - bounds.bottom;

        x = (screenSize.getHeight() - height) / 2.0;
        y = (screenSize.getWidth() - width) / 2.0;

        frmMain.setBounds((int) x, (int) y, (int) width, (int) height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consoleTA = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        deptMI = new javax.swing.JMenuItem();
        empMI = new javax.swing.JMenuItem();
        notificationMI = new javax.swing.JMenuItem();
        fileStoreET = new javax.swing.JMenuItem();
        chatMI = new javax.swing.JMenuItem();
        scMI = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        startRequestServerMI = new javax.swing.JMenuItem();
        clearConsoleMI = new javax.swing.JMenuItem();
        logoutMI = new javax.swing.JMenuItem();
        exitMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN HOME");

        consoleTA.setEditable(false);
        consoleTA.setColumns(20);
        consoleTA.setRows(5);
        consoleTA.setDragEnabled(true);
        jScrollPane1.setViewportView(consoleTA);

        jMenu1.setText("File");

        deptMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        deptMI.setText("Department");
        deptMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptMIActionPerformed(evt);
            }
        });
        jMenu1.add(deptMI);

        empMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        empMI.setText("Employee");
        empMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empMIActionPerformed(evt);
            }
        });
        jMenu1.add(empMI);

        notificationMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        notificationMI.setText("Notification");
        notificationMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationMIActionPerformed(evt);
            }
        });
        jMenu1.add(notificationMI);

        fileStoreET.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        fileStoreET.setText("File Store");
        fileStoreET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileStoreETActionPerformed(evt);
            }
        });
        jMenu1.add(fileStoreET);

        chatMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        chatMI.setText("Chat");
        chatMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatMIActionPerformed(evt);
            }
        });
        jMenu1.add(chatMI);

        scMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        scMI.setText("Schedule Capture");
        scMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scMIActionPerformed(evt);
            }
        });
        jMenu1.add(scMI);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Settings");

        startRequestServerMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        startRequestServerMI.setText("Start Request Server");
        startRequestServerMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRequestServerMIActionPerformed(evt);
            }
        });
        jMenu3.add(startRequestServerMI);

        clearConsoleMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        clearConsoleMI.setText("Clear Console");
        clearConsoleMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearConsoleMIActionPerformed(evt);
            }
        });
        jMenu3.add(clearConsoleMI);

        logoutMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        logoutMI.setText("Logout");
        logoutMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMIActionPerformed(evt);
            }
        });
        jMenu3.add(logoutMI);

        exitMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMI.setText("Exit");
        exitMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMIActionPerformed(evt);
            }
        });
        jMenu3.add(exitMI);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 256, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMIActionPerformed
        AdminLogin al = new AdminLogin();
        al.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutMIActionPerformed

    private void exitMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMIActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMIActionPerformed

    private void empMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empMIActionPerformed
        if (!Variables.employeeFormOpenStatus) {
            employee = new Employee();
            this.add(employee);
            employee.setVisible(true);
            Variables.employeeFormOpenStatus = true;
        }

    }//GEN-LAST:event_empMIActionPerformed

    private void deptMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptMIActionPerformed
        department = new Department();
        this.add(department);
        department.setVisible(true);
    }//GEN-LAST:event_deptMIActionPerformed

    private void notificationMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationMIActionPerformed
        notification = new Notification();
        this.add(notification);
        notification.setVisible(true);
    }//GEN-LAST:event_notificationMIActionPerformed

    private void fileStoreETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileStoreETActionPerformed
        fileStore = new FileStore();
        this.add(fileStore);
        fileStore.setVisible(true);
    }//GEN-LAST:event_fileStoreETActionPerformed

    private void chatMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatMIActionPerformed
        chat = new Chat();
        this.add(chat);
        chat.setVisible(true);
    }//GEN-LAST:event_chatMIActionPerformed

    private void clearConsoleMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearConsoleMIActionPerformed
        consoleTA.setText(null);
    }//GEN-LAST:event_clearConsoleMIActionPerformed

    private void scMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scMIActionPerformed
        capture = new ScheduleCapture();
        this.add(capture);
        capture.setVisible(true);
    }//GEN-LAST:event_scMIActionPerformed

    private void startRequestServerMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRequestServerMIActionPerformed

        try {

            boolean flag = false;
            if ("Stop Request Server".equals(startRequestServerMI.getText())) {
                flag = true;

            }

            if (flag) {
                requestServer.serverSocket.close();
                requestServer.socket.close();
                startRequestServerMI.setText("Start Request Server");
                writeToConsole("Request Server stopped");
                flag = false;
            } else {

                boolean result = CheckPortAvailability.isPortAvailable(Variables.RequestServerPort);
                if (result) {
                    System.out.println(">>>>>>>");
                    requestServer = new RequestServer(Variables.RequestServerPort);
                    startRequestServerMI.setText("Stop Request Server");
                    flag = true;
                    writeToConsole("Request Server started at port>>> " + Variables.RequestServerPort);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_startRequestServerMIActionPerformed
    public static void writeToConsole(String msg) {
        consoleTA.append(">>" + msg + "\n");
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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem chatMI;
    private javax.swing.JMenuItem clearConsoleMI;
    private static javax.swing.JTextArea consoleTA;
    private javax.swing.JMenuItem deptMI;
    private javax.swing.JMenuItem empMI;
    private javax.swing.JMenuItem exitMI;
    private javax.swing.JMenuItem fileStoreET;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem logoutMI;
    private javax.swing.JMenuItem notificationMI;
    private javax.swing.JMenuItem scMI;
    private javax.swing.JMenuItem startRequestServerMI;
    // End of variables declaration//GEN-END:variables
}
