/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw.client;

import edu.dda.models.ChatHistoryModel;
import edu.dda.models.DepartmentModel;
import edu.dda.models.EmpDeptMapModel;
import edu.dda.models.EmpDetailsModel;
import edu.dda.models.EmpLoginModel;
import edu.dda.models.FileDeptMapModel;
import edu.dda.models.FileStoreModel;
import edu.dda.models.NotificationModel;
import edu.dda.models.ScheduleCaptureModel;
import edu.dda.utils.Variables;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author pvr
 */
public class DDAClient {

    static String ip = "192.168.1.193";
    static int port = 1234;

    public static boolean adminLogin(String uname, String passwd) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("adminLogin");
            ps.println(uname);
            ps.println(passwd);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean addDept(String deptName) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("addDept");
            ps.println(deptName);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean addNotification(String msgName, String msg) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("addNotification");
            ps.println(msgName);
            ps.println(msg);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean addEmp(String fname, String lname, String phone, String email, String deptId, String passwd) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("addEmp");
            ps.println(fname);
            ps.println(lname);
            ps.println(phone);
            ps.println(email);
            ps.println(passwd);
            ps.println(deptId);

            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean editDept(int deptId, String deptName) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("editDept");
            ps.println(deptId);
            ps.println(deptName);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean deleteDept(int deptId) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("deleteDept");
            ps.println(deptId);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean deleteFile(int fileId, String fileName, int deptId) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("deleteFile");
            ps.println(fileId);
            ps.println(fileName);
            ps.println(deptId);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean deleteNotification(int notiId) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("deleteNotification");
            ps.println(notiId);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<DepartmentModel> getAllDept() {
        String allDept = "";
        ArrayList<DepartmentModel> departmentModels = new ArrayList<>();
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("getAllDept");
            allDept = br.readLine().trim().replace("[", "").replace("]", "");
            ps.println("exit");
            is.close();
            os.close();
            if (!"".equals(allDept)) {
                String deptArray[] = allDept.split(",");
                for (int i = 0; i < deptArray.length; i++) {
                    String dept[] = deptArray[i].split("#");
                    int id = Integer.parseInt(dept[0].trim());
                    String deptName = dept[1].trim();
                    DepartmentModel dm = new DepartmentModel(id, deptName);
                    departmentModels.add(dm);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentModels;
    }

    public static ArrayList<EmpDetailsModel> getAllEmpDetails() {
        String allEmpDetails = "";
        ArrayList<EmpDetailsModel> empDetailsModels = new ArrayList<>();
        ArrayList<EmpLoginModel> loginModels = new ArrayList<>();
        ArrayList<EmpDeptMapModel> mapModels = new ArrayList<>();
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("getAllEmpDetails");
            allEmpDetails = br.readLine().trim().replace("[", "").replace("]", "");
            ps.println("exit");
            is.close();
            os.close();
            if (!"".equals(allEmpDetails)) {
                String allEmpDetailsArray[] = allEmpDetails.split(",");
                for (int i = 0; i < allEmpDetailsArray.length; i++) {
                    String emp[] = allEmpDetailsArray[i].split("#");
                    int id = Integer.parseInt(emp[0].trim());
                    String fname = emp[1].trim();
                    String lname = emp[2].trim();
                    String phone = emp[3].trim();
                    String email = emp[4].trim();
                    String status = emp[5].trim();
                    String sessionStatus = emp[6].trim();
                    int deptId = Integer.parseInt(emp[7].trim());
                    EmpLoginModel elm = new EmpLoginModel(id, email, "", status, sessionStatus);
                    EmpDeptMapModel edmm = new EmpDeptMapModel(id, id, deptId);
                    EmpDetailsModel edm = new EmpDetailsModel(id, fname, lname, phone, elm, edmm);
                    empDetailsModels.add(edm);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return empDetailsModels;
    }

    public static ArrayList<EmpDetailsModel> getAllOnlineEmpDetails() {
        String allEmpDetails = "";
        ArrayList<EmpDetailsModel> empDetailsModels = new ArrayList<>();
        ArrayList<EmpLoginModel> loginModels = new ArrayList<>();
        ArrayList<EmpDeptMapModel> mapModels = new ArrayList<>();
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("getAllOnlineEmpDetails");
            allEmpDetails = br.readLine().trim().replace("[", "").replace("]", "");
            ps.println("exit");
            is.close();
            os.close();
            if (!"".equals(allEmpDetails)) {
                String allEmpDetailsArray[] = allEmpDetails.split(",");
                for (int i = 0; i < allEmpDetailsArray.length; i++) {
                    String emp[] = allEmpDetailsArray[i].split("#");
                    int id = Integer.parseInt(emp[0].trim());
                    String fname = emp[1].trim();
                    String lname = emp[2].trim();
                    String phone = emp[3].trim();
                    String email = emp[4].trim();
                    String status = emp[5].trim();
                    String sessionStatus = emp[6].trim();
                    int deptId = Integer.parseInt(emp[7].trim());
                    EmpLoginModel elm = new EmpLoginModel(id, email, "", status, sessionStatus);
                    EmpDeptMapModel edmm = new EmpDeptMapModel(id, id, deptId);
                    EmpDetailsModel edm = new EmpDetailsModel(id, fname, lname, phone, elm, edmm);
                    empDetailsModels.add(edm);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return empDetailsModels;
    }

    public static boolean manageEmp(String empId, String action) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("manageEmp");
            ps.println(empId);
            ps.println(action);
            result = Boolean.valueOf(br.readLine().trim());
            ps.println("exit");
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<NotificationModel> getAllNotifications() {
        ArrayList<NotificationModel> notificationModels = new ArrayList<>();

        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream os = null;
            inputStream = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(os);
            printStream.println("getAllNotifications");
            String allNotifications = br.readLine().trim().replace("[", "").replace("]", "");
            printStream.println("exit");
            if (!"".equals(allNotifications)) {
                String notifications[] = allNotifications.split(",");
                for (int i = 0; i < notifications.length; i++) {
                    String noti[] = notifications[i].split("#");
                    int id = Integer.parseInt(noti[0].trim());
                    String msgName = noti[1].trim();
                    String msg = noti[2].trim();
                    String ntDate = noti[3].trim();
                    String ntTime = noti[4].trim();
                    NotificationModel nm = new NotificationModel(id, msgName, msg, ntDate, ntTime);
                    notificationModels.add(nm);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return notificationModels;
    }

    public static ArrayList<FileStoreModel> getAllFiles() {
        ArrayList<FileStoreModel> fileStoreModels = new ArrayList<>();

        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream os = null;
            inputStream = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(os);
            printStream.println("getAllFiles");
            String allFiles = br.readLine().trim().replace("[", "").replace("]", "");
            printStream.println("exit");
            if (!"".equals(allFiles)) {
                String files[] = allFiles.split(",");
                for (int i = 0; i < files.length; i++) {
                    String file[] = files[i].split("#");
                    int fileId = Integer.parseInt(file[0].trim());
                    String fileName = file[1].trim();
                    String fileSize = file[2].trim();
                    String upDate = file[3].trim();
                    String upTime = file[4].trim();
                    int deptId = Integer.parseInt(file[5].trim());
                    FileDeptMapModel fdmm = new FileDeptMapModel(fileId, fileId, deptId);
                    FileStoreModel fsm = new FileStoreModel(fileId, fileName, fileSize, upDate, upTime, fdmm);
                    fileStoreModels.add(fsm);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileStoreModels;
    }

    public static boolean addChatHistory(int fromId, int toId, String fromUtype, String toUtype, String msg) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream os = null;
            inputStream = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(os);
            printStream.println("addChatHistory");
            printStream.println(toId);
            printStream.println(fromId);
            printStream.println(fromUtype);
            printStream.println(toUtype);
            printStream.println(msg);
            result = Boolean.valueOf(br.readLine().trim());
            printStream.println("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<ChatHistoryModel> getAllChatHistory() {
        String allChatHistory = "";
        ArrayList<ChatHistoryModel> historyModels = new ArrayList<>();
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("getAllChatHistory");
            allChatHistory = br.readLine().trim().replace("[", "").replace("]", "");
            ps.println("exit");
            is.close();
            os.close();
            if (!"".equals(allChatHistory)) {
                String deptArray[] = allChatHistory.split(",");
                for (int i = 0; i < deptArray.length; i++) {
                    String dept[] = deptArray[i].split("#");
                    int id = Integer.parseInt(dept[0].trim());
                    int fromId = Integer.parseInt(dept[1].trim());
                    int toId = Integer.parseInt(dept[2].trim());
                    String fromUtype = dept[3].trim();
                    String toUtype = dept[4].trim();
                    String msg = dept[5].trim();
                    String ctDate = dept[6].trim();
                    String ctTime = dept[7].trim();
                    ChatHistoryModel chm = new ChatHistoryModel(id, fromId, toId, fromUtype, toUtype, msg, ctDate, ctTime);
                    historyModels.add(chm);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyModels;
    }

    public static ArrayList<ScheduleCaptureModel> getAllRequestedScheduleCapture() {
        String allScheduleCaptue = "";
        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = new ArrayList<>();
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("getAllRequestedScheduleCapture");
            allScheduleCaptue = br.readLine().trim().replace("[", "").replace("]", "");
            ps.println("exit");
            is.close();
            os.close();
            if (!"".equals(allScheduleCaptue)) {
                String deptArray[] = allScheduleCaptue.split(",");
                for (int i = 0; i < deptArray.length; i++) {
                    String schedule[] = deptArray[i].split("#");
                    int id = Integer.parseInt(schedule[0].trim());
                    int empId = Integer.parseInt(schedule[1].trim());
                    String dcDate = schedule[2].trim();
                    String fromTime = schedule[3].trim();
                    String toTime = schedule[4].trim();
                    String status = schedule[5].trim();
                    ScheduleCaptureModel scm = new ScheduleCaptureModel(id, empId, dcDate, fromTime, toTime, status);
                    scheduleCaptureModels.add(scm);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleCaptureModels;
    }

    public static ArrayList<ScheduleCaptureModel> getAllScheduledScheduleCapture() {
        String allScheduleCaptue = "";
        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = new ArrayList<>();
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("getAllScheduledScheduleCapture");
            allScheduleCaptue = br.readLine().trim().replace("[", "").replace("]", "");
            ps.println("exit");
            is.close();
            os.close();
            if (!"".equals(allScheduleCaptue)) {
                String deptArray[] = allScheduleCaptue.split(",");
                for (int i = 0; i < deptArray.length; i++) {
                    String schedule[] = deptArray[i].split("#");
                    int id = Integer.parseInt(schedule[0].trim());
                    int empId = Integer.parseInt(schedule[1].trim());
                    String dcDate = schedule[2].trim();
                    String fromTime = schedule[3].trim();
                    String toTime = schedule[4].trim();
                    String status = schedule[5].trim();
                    ScheduleCaptureModel scm = new ScheduleCaptureModel(id, empId, dcDate, fromTime, toTime, status);
                    scheduleCaptureModels.add(scm);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleCaptureModels;
    }
    public static ArrayList<ScheduleCaptureModel> getAllRejectedScheduleCapture() {
        String allScheduleCaptue = "";
        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = new ArrayList<>();
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream ps = null;
            InputStream is = null;
            OutputStream os = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("getAllRejectedScheduleCapture");
            allScheduleCaptue = br.readLine().trim().replace("[", "").replace("]", "");
            ps.println("exit");
            is.close();
            os.close();
            if (!"".equals(allScheduleCaptue)) {
                String deptArray[] = allScheduleCaptue.split(",");
                for (int i = 0; i < deptArray.length; i++) {
                    String schedule[] = deptArray[i].split("#");
                    int id = Integer.parseInt(schedule[0].trim());
                    int empId = Integer.parseInt(schedule[1].trim());
                    String dcDate = schedule[2].trim();
                    String fromTime = schedule[3].trim();
                    String toTime = schedule[4].trim();
                    String status = schedule[5].trim();
                    ScheduleCaptureModel scm = new ScheduleCaptureModel(id, empId, dcDate, fromTime, toTime, status);
                    scheduleCaptureModels.add(scm);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleCaptureModels;
    }

    public static boolean clearChatHistory() {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream os = null;
            inputStream = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(os);
            printStream.println("clearChatHistory");
            result = Boolean.valueOf(br.readLine().trim());
            printStream.println("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean updateScheduleCaptureStatus(int id, String status) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader br = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream os = null;
            inputStream = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(os);
            printStream.println("updateScheduleCaptureStatus");
            printStream.println(id);
            printStream.println(status);
            result = Boolean.valueOf(br.readLine().trim());
            printStream.println("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        getAllDept();
    }
}
