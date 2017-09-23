/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw;

import edu.dda.db.DbProcess;
import edu.dda.models.AdminLoginModel;
import edu.dda.models.ChatHistoryModel;
import edu.dda.models.DepartmentModel;
import edu.dda.models.EmpDeptMapModel;
import edu.dda.models.EmpDetailsModel;
import edu.dda.models.EmpLoginModel;
import edu.dda.models.FileStoreModel;
import edu.dda.models.NotificationModel;
import edu.dda.models.ScheduleCaptureModel;
import edu.dda.utils.DateAndTime;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author pvr
 */
public class DDAServer implements Runnable {

    ServerSocket serverSocket = null;
    Socket socket = null;

    public DDAServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("DDA SERVER STARTED AT PORT>>>" + port);
            new Thread(this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println("Client Connected>>>");
                new DDAChild(socket).start();
                System.out.println("DDA Child Started>>>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DDAChild extends Thread {

        Socket s = null;
        BufferedReader br = null;
        PrintStream ps = null;
        InputStream is = null;
        OutputStream os = null;
        DbProcess dbProcess = null;

        public DDAChild(Socket socket) {
            try {
                s = socket;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {

                is = s.getInputStream();
                os = s.getOutputStream();
                br = new BufferedReader(new InputStreamReader(is));
                ps = new PrintStream(os);

                while (true) {
                    String msg = br.readLine();
                    if (msg == null) {
                        break;
                    }
                    if (msg.equals("exit")) {
                        break;
                    } else if (msg.equals("adminLogin")) {
                        String uname = br.readLine();
                        String passwd = br.readLine();
                        dbProcess = new DbProcess();
                        AdminLoginModel alm = new AdminLoginModel(0, uname, passwd);
                        boolean result = dbProcess.adminLogin(alm);
                        ps.println(result);
                    } else if (msg.equals("addDept")) {
                        String deptName = br.readLine();
                        dbProcess = new DbProcess();
                        DepartmentModel dm = new DepartmentModel(0, deptName);
                        boolean result = dbProcess.addDept(dm);
                        ps.println(result);
                    } else if (msg.equals("getAllDept")) {
                        dbProcess = new DbProcess();
                        ArrayList<DepartmentModel> departmentModels = dbProcess.getAllDept();
                        ps.println(departmentModels);
                    } else if (msg.equals("editDept")) {
                        int deptId = Integer.parseInt(br.readLine().trim());
                        String deptName = br.readLine().trim();
                        dbProcess = new DbProcess();
                        DepartmentModel dm = new DepartmentModel(deptId, deptName);
                        boolean result = dbProcess.editDept(dm);
                        ps.println(result);
                    } else if (msg.equals("deleteDept")) {
                        int deptId = Integer.parseInt(br.readLine().trim());
                        dbProcess = new DbProcess();
                        boolean result = dbProcess.deleteDept(deptId);
                        ps.println(result);
                    } else if (msg.equals("addEmp")) {
                        String fname = br.readLine();
                        String lname = br.readLine();
                        String phone = br.readLine();
                        String email = br.readLine();
                        String passwd = br.readLine();
                        int deptId = Integer.parseInt(br.readLine().trim());
                        EmpLoginModel elm = new EmpLoginModel(0, email, passwd, "", "");
                        EmpDeptMapModel edmm = new EmpDeptMapModel(0, 0, deptId);
                        EmpDetailsModel edm = new EmpDetailsModel(0, fname, lname, phone, elm, edmm);
                        dbProcess = new DbProcess();
                        boolean result = dbProcess.addEmp(edm);
                        ps.println(result);
                    } else if (msg.equals("getAllEmpDetails")) {
                        dbProcess = new DbProcess();
                        ArrayList<EmpDetailsModel> empDetailsModels = dbProcess.getAllEmpDetails();
                        ps.println(empDetailsModels);
                    } else if (msg.equals("manageEmp")) {
                        int empId = Integer.parseInt(br.readLine().trim());
                        String action = br.readLine().trim();
                        dbProcess = new DbProcess();
                        boolean result = dbProcess.manageDept(empId, action);
                        ps.println(result);
                    } else if (msg.equals("empLogin")) {
                        String email = br.readLine();
                        String passwd = br.readLine();
                        dbProcess = new DbProcess();
                        EmpLoginModel elm = new EmpLoginModel(0, email, passwd, "", "");
                        int empId = dbProcess.empLogin(elm);
                        ps.println(empId);
                    } else if (msg.equals("empLogout")) {
                        int empId = Integer.parseInt(br.readLine().trim());
                        dbProcess = new DbProcess();
                        boolean result = dbProcess.empLogout(empId);
                        ps.println(result);
                    } else if (msg.equals("addNotification")) {
                        String msgName = br.readLine();
                        msg = br.readLine();
                        String nDate = DateAndTime.getCurrentDate();
                        String nTime = DateAndTime.getCurrentTime();
                        dbProcess = new DbProcess();
                        NotificationModel nm = new NotificationModel(0, msgName, msg, nDate, nTime);
                        boolean result = dbProcess.addNotification(nm);
                        ps.println(result);
                    } else if (msg.equals("getAllNotifications")) {
                        dbProcess = new DbProcess();
                        ArrayList<NotificationModel> notificationModels = dbProcess.getAllNotifications();
                        ps.println(notificationModels);
                    } else if (msg.equals("deleteNotification")) {
                        int notiId = Integer.parseInt(br.readLine().trim());
                        dbProcess = new DbProcess();
                        boolean result = dbProcess.deleteNotification(notiId);
                        ps.println(result);
                    } else if (msg.equals("getAllFilesByDept")) {
                        int empId = Integer.parseInt(br.readLine().trim());
                        System.out.println("empId = " + empId);
                        dbProcess = new DbProcess();
                        int deptId = dbProcess.getDeptId(empId);
                        ArrayList<FileStoreModel> fileStoreModel = dbProcess.getAllFilesByDept(deptId);
                        ps.println(fileStoreModel);
                    } else if (msg.equals("getAllFiles")) {
                        dbProcess = new DbProcess();
                        ArrayList<FileStoreModel> fileStoreModel = dbProcess.getAllFiles();
                        ps.println(fileStoreModel);
                    } else if (msg.equals("deleteFile")) {
                        int fileId = Integer.parseInt(br.readLine().trim());
                        String fileName = br.readLine().trim();
                        int deptId = Integer.parseInt(br.readLine().trim());
                        dbProcess = new DbProcess();
                        boolean result = dbProcess.deleteFile(fileId);
                        if (result) {
                            String deptName = dbProcess.getDeptName(deptId);
                            String filePath = "FileStore" + File.separator + deptName + File.separator + fileName;
                            File file = new File(filePath);
                            if (file.exists()) {
                                file.delete();
                            }

                        }
                        ps.println(result);
                    } else if (msg.equals("getAllOnlineEmpDetails")) {
                        dbProcess = new DbProcess();
                        ArrayList<EmpDetailsModel> empDetailsModels = dbProcess.getAllOnlineEmpDetails();
                        ps.println(empDetailsModels);
                    } else if (msg.equals("addChatHistory")) {
                        dbProcess = new DbProcess();
                        int toId = Integer.parseInt(br.readLine().trim());
                        int fromId = Integer.parseInt(br.readLine().trim());
                        String fromUtype = br.readLine().trim();
                        String toUtype = br.readLine().trim();
                        String message = br.readLine().trim();
                        String ctDate = DateAndTime.getCurrentDate();
                        String ctTime = DateAndTime.getCurrentTime();
                        ChatHistoryModel chm = new ChatHistoryModel(0, fromId, toId, fromUtype, toUtype, message, ctDate, ctTime);
                        boolean result = dbProcess.addChatHistory(chm);
                        ps.println(result);
                    } else if (msg.equals("getAllChatHistory")) {
                        dbProcess = new DbProcess();
                        ArrayList<ChatHistoryModel> historyModels = dbProcess.getAllChatHistory();
                        ps.println(historyModels);
                    } else if (msg.equals("clearChatHistory")) {
                        dbProcess = new DbProcess();
                        boolean result = dbProcess.clearChatHistory();
                        ps.println(result);
                    } else if (msg.equals("getEmpChatHistory")) {
                        dbProcess = new DbProcess();
                        int empId = Integer.parseInt(br.readLine().trim());
                        ArrayList<ChatHistoryModel> historyModels = dbProcess.getEmpChatHistory(empId);
                        ps.println(historyModels);
                    } else if (msg.equals("scheduleNow")) {
                        dbProcess = new DbProcess();
                        int empId = Integer.parseInt(br.readLine().trim());
                        String date = br.readLine().trim();
                        String fromTime = br.readLine().trim();
                        String toTime = br.readLine().trim();
                        ScheduleCaptureModel scm = new ScheduleCaptureModel(0, empId, date, fromTime, toTime, "");
                        boolean result = dbProcess.scheduleCaptureNow(scm);
                        ps.println(result);
                    } else if (msg.equals("getAllRequestedScheduleCapture")) {
                        dbProcess = new DbProcess();
                        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = dbProcess.getAllRequestedScheduleCapture();
                        ps.println(scheduleCaptureModels);
                    } else if (msg.equals("getAllScheduledScheduleCapture")) {
                        dbProcess = new DbProcess();
                        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = dbProcess.getAllScheduledScheduleCapture();
                        ps.println(scheduleCaptureModels);
                    } else if (msg.equals("updateScheduleCaptureStatus")) {
                        dbProcess = new DbProcess();
                        int id = Integer.parseInt(br.readLine());
                        String status = br.readLine();
                        boolean result = dbProcess.updateScheduleCaptureStatus(id, status);
                        ps.println(result);
                    } else if (msg.equals("getAllRejectedScheduleCapture")) {
                        dbProcess = new DbProcess();
                        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = dbProcess.getAllRejectedScheduleCapture();
                        ps.println(scheduleCaptureModels);
                    } else if (msg.equals("checkCaptureSchedule")) {
                        dbProcess = new DbProcess();
                        int empId=Integer.parseInt(br.readLine());
                        String date=DateAndTime.getCurrentDate();
                        String time=DateAndTime.getCurrentTime();
                        boolean result=dbProcess.checkScheduleCapture(empId, date, time);
                        ps.println(result);
                        
                        

                    }

                }
                is.close();
                os.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DDAServer dDAServer = new DDAServer(1234);
    }
}
