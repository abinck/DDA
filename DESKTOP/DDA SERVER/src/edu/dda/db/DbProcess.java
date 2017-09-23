package edu.dda.db;

import edu.dda.models.AdminLoginModel;
import edu.dda.models.ChatHistoryModel;
import edu.dda.models.DepartmentModel;
import edu.dda.models.EmpDeptMapModel;
import edu.dda.models.EmpDetailsModel;
import edu.dda.models.EmpLoginModel;
import edu.dda.models.FileDeptMapModel;
import edu.dda.models.FileStoreModel;
import edu.dda.models.NotificationModel;
import edu.dda.models.ScheduleCaptureModel;
import edu.dda.utils.DateAndTime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pvr
 */
public class DbProcess extends DbCon {

    private String sql = "";
    private int i = 0;
    private ResultSet rs = null;
    private String tables[] = new String[11];
    private boolean flag = false;
    private String dbName = "dda";

    public DbProcess() {
        super();
        try {

            sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + dbName + "'";
            rs = getData(sql);
            if (!rs.next()) {
                sql = "CREATE SCHEMA IF NOT EXISTS " + dbName;
                putData(sql);
                sql = "USE " + dbName;
                putData(sql);
                createSchemaAndTables();
            }
            rs.close();
            sql = "USE " + dbName;
            putData(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSchemaAndTables() {
        try {
            //ADMIN LOGIN
            tables[0] = "CREATE TABLE `admin_login` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `uname` varchar(45) NOT NULL,\n"
                    + "  `passwd` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  UNIQUE KEY `uname_UNIQUE` (`uname`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //CHAT HISTORY
            tables[1] = "CREATE TABLE `chat_history` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `fromId` int(11) NOT NULL,\n"
                    + "  `toId` int(11) NOT NULL,\n"
                    + "  `fromUtype` varchar(45) NOT NULL,\n"
                    + "  `toUtype` varchar(45) NOT NULL,\n"
                    + "  `msg` varchar(45) NOT NULL,\n"
                    + "  `ctDate` varchar(45) NOT NULL,\n"
                    + "  `ctTime` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //DEPT
            tables[2] = "CREATE TABLE `department` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `deptName` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //EMP LOGIN
            tables[3] = "CREATE TABLE `emp_login` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `email` varchar(45) NOT NULL,\n"
                    + "  `passwd` varchar(45) NOT NULL,\n"
                    + "  `status` varchar(45) NOT NULL,\n"
                    + "  `sessionStatus` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  UNIQUE KEY `email_UNIQUE` (`email`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //EMP DETAILS
            tables[4] = "CREATE TABLE `emp_details` (\n"
                    + "  `id` int(11) NOT NULL,\n"
                    + "  `fname` varchar(45) NOT NULL,\n"
                    + "  `lname` varchar(45) NOT NULL,\n"
                    + "  `phone` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  CONSTRAINT `fk_emp_details_1` FOREIGN KEY (`id`) REFERENCES `emp_login` (`id`) ON DELETE CASCADE ON UPDATE CASCADE\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //EMP DEPT MAP
            tables[5] = "CREATE TABLE `emp_dept_map` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `empId` int(11) NOT NULL,\n"
                    + "  `deptId` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  KEY `fk_emp_dept_map_1_idx` (`empId`),\n"
                    + "  CONSTRAINT `fk_emp_dept_map_1` FOREIGN KEY (`empId`) REFERENCES `emp_login` (`id`) ON DELETE CASCADE ON UPDATE CASCADE\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //EMP LOG
            tables[6] = "CREATE TABLE `emp_log` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `userId` int(11) NOT NULL,\n"
                    + "  `logName` varchar(45) NOT NULL,\n"
                    + "  `logDate` varchar(45) NOT NULL,\n"
                    + "  `logTime` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //FILE STORE
            tables[7] = "CREATE TABLE `file_store` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `fileName` varchar(45) NOT NULL,\n"
                    + "  `fileSize` varchar(45) NOT NULL,\n"
                    + "  `upDate` varchar(45) NOT NULL,\n"
                    + "  `upTime` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //FILE DEPT MAP
            tables[8] = "CREATE TABLE `file_dept_map` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `fileId` int(11) NOT NULL,\n"
                    + "  `deptId` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  KEY `fk_file_dept_map_1_idx` (`fileId`),\n"
                    + "  CONSTRAINT `fk_file_dept_map_1` FOREIGN KEY (`fileId`) REFERENCES `file_store` (`id`) ON DELETE CASCADE ON UPDATE CASCADE\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //NOTIFICATION
            tables[9] = "CREATE TABLE `notification` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `msgName` varchar(45) NOT NULL,\n"
                    + "  `msg` varchar(45) NOT NULL,\n"
                    + "  `ntDate` varchar(45) NOT NULL,\n"
                    + "  `ntTime` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            //SCHEDULE CAPTURE
            tables[10] = "CREATE TABLE `schedule_capture` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `empId` int(11) NOT NULL,\n"
                    + "  `scDate` date NOT NULL,\n"
                    + "  `fromTime` time NOT NULL,\n"
                    + "  `toTime` time NOT NULL,\n"
                    + "  `status` varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

            for (int i = 0; i < tables.length; i++) {
                putData(tables[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean adminLogin(AdminLoginModel alm) {
        try {
            sql = "select * from admin_login where uname='" + alm.getUname() + "' and passwd='" + alm.getPasswd() + "'";
            rs = getData(sql);
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int empLogin(EmpLoginModel elm) {
        int empId = 0;
        try {
            sql = "select * from emp_login where email='" + elm.getEmail() + "' and passwd='" + elm.getPasswd() + "'";
            rs = getData(sql);
            if (rs.next()) {
                int id = rs.getInt("id");
                sql = "update emp_login set sessionStatus='online' where email='" + elm.getEmail() + "'";
                i = putData(sql);
                if (i > 0) {
                    
                    empId = id;
                    insertEmpLog("Logged In", empId);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empId;
    }

    public boolean empLogout(int empId) {
        try {
            sql = "update emp_login set sessionStatus='offline' where id=" + empId + "";
            i = putData(sql);
            if (i > 0) {
                insertEmpLog("Logged Out", empId);
                flag = true;
            }
        } catch (Exception e) {
        }
        return flag;
    }

    public boolean addDept(DepartmentModel dm) {
        try {
            sql = "insert into department values(0,'" + dm.getDeptName() + "')";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addNotification(NotificationModel nm) {
        try {
            sql = "insert into notification values(0,'" + nm.getMsgName() + "','" + nm.getMsg() + "','" + nm.getNtDate() + "','" + nm.getNtTime() + "')";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addEmp(EmpDetailsModel edm) {
        try {
            sql = "insert into emp_login values(0,'" + edm.getLoginModel().getEmail() + "','" + edm.getLoginModel().getPasswd() + "','active','offline')";
            i = putData(sql);
            if (i > 0) {
                i = 0;
                sql = "insert into emp_details values((select id from emp_login where email='" + edm.getLoginModel().getEmail() + "'),'" + edm.getFname() + "','" + edm.getLname() + "','" + edm.getPhone() + "')";
                i = putData(sql);
                if (i > 0) {
                    i = 0;
                    sql = "insert into emp_dept_map values(0,(select id from emp_login where email='" + edm.getLoginModel().getEmail() + "')," + edm.getMapModel().getDeptId() + ")";
                    i = putData(sql);
                    if (i > 0) {
                        return true;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean editDept(DepartmentModel dm) {
        try {
            sql = "update department set deptName='" + dm.getDeptName() + "' where id=" + dm.getId() + "";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteDept(int id) {
        try {
            sql = "delete from department where id=" + id + "";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteFile(int id) {
        try {
            sql = "delete from file_store where id=" + id + "";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteNotification(int id) {
        try {
            sql = "delete from notification where id=" + id + "";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean manageDept(int empId, String action) {
        try {
            if ("block".equals(action)) {
                sql = "update emp_login set status='inactive' where id=" + empId + "";
            } else if ("unblock".equals(action)) {
                sql = "update emp_login set status='active' where id=" + empId + "";
            } else {
                sql = "delete from emp_login where id=" + empId + "";
            }
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<DepartmentModel> getAllDept() {
        ArrayList<DepartmentModel> departmentModels = null;
        try {
            departmentModels = new ArrayList<>();
            sql = "select * from department";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String deptName = rs.getString("deptName");
                DepartmentModel dm = new DepartmentModel(id, deptName);
                departmentModels.add(dm);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return departmentModels;
    }

    public ArrayList<ChatHistoryModel> getAllChatHistory() {
        ArrayList<ChatHistoryModel> historyModels = null;
        try {
            historyModels = new ArrayList<>();
            sql = "select * from chat_history";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int fromId = rs.getInt("fromId");
                int toId = rs.getInt("toId");
                String fromUtype = rs.getString("fromUtype");
                String toUtype = rs.getString("toUtype");
                String msg = rs.getString("msg");
                String ctDate = rs.getString("ctDate");
                String ctTime = rs.getString("ctTime");
                ChatHistoryModel chm = new ChatHistoryModel(id, fromId, toId, fromUtype, toUtype, msg, ctDate, ctTime);
                historyModels.add(chm);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return historyModels;
    }

    public ArrayList<ChatHistoryModel> getEmpChatHistory(int empId) {
        ArrayList<ChatHistoryModel> historyModels = null;
        try {
            historyModels = new ArrayList<>();
            sql = "select * from chat_history where fromId=" + empId + " or toId=" + empId + "";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int fromId = rs.getInt("fromId");
                int toId = rs.getInt("toId");
                String fromUtype = rs.getString("fromUtype");
                String toUtype = rs.getString("toUtype");
                String msg = rs.getString("msg");
                String ctDate = rs.getString("ctDate");
                String ctTime = rs.getString("ctTime");
                ChatHistoryModel chm = new ChatHistoryModel(id, fromId, toId, fromUtype, toUtype, msg, ctDate, ctTime);
                historyModels.add(chm);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return historyModels;
    }

    public ArrayList<EmpDetailsModel> getAllEmpDetails() {
        ArrayList<EmpDetailsModel> empDetailsModels = null;
        try {
            empDetailsModels = new ArrayList<>();
            sql = "select * from emp_details ed,emp_login el,emp_dept_map edm where ed.id=el.id and el.id=edm.empId";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String status = rs.getString("status");
                String sessionStatus = rs.getString("sessionStatus");
                EmpLoginModel elm = new EmpLoginModel(id, email, "", status, sessionStatus);
                int deptId = rs.getInt("deptId");
                EmpDeptMapModel edmm = new EmpDeptMapModel(0, id, deptId);
                EmpDetailsModel edm = new EmpDetailsModel(id, fname, lname, phone, elm, edmm);
                empDetailsModels.add(edm);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return empDetailsModels;
    }

    public ArrayList<EmpDetailsModel> getAllOnlineEmpDetails() {
        ArrayList<EmpDetailsModel> empDetailsModels = null;
        try {
            empDetailsModels = new ArrayList<>();
            sql = "select * from emp_details ed,emp_login el,emp_dept_map edm where ed.id=el.id and el.id=edm.empId and el.sessionStatus='online'";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String status = rs.getString("status");
                String sessionStatus = rs.getString("sessionStatus");
                EmpLoginModel elm = new EmpLoginModel(id, email, "", status, sessionStatus);
                int deptId = rs.getInt("deptId");
                EmpDeptMapModel edmm = new EmpDeptMapModel(0, id, deptId);
                EmpDetailsModel edm = new EmpDetailsModel(id, fname, lname, phone, elm, edmm);
                empDetailsModels.add(edm);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return empDetailsModels;
    }

    public ArrayList<NotificationModel> getAllNotifications() {
        ArrayList<NotificationModel> notificationModels = null;
        try {
            notificationModels = new ArrayList<>();
            sql = "select * from notification";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String msgName = rs.getString("msgName");
                String msg = rs.getString("msg");
                String ntDate = rs.getString("ntDate");
                String ntTime = rs.getString("ntTime");
                NotificationModel nm = new NotificationModel(id, msgName, msg, ntDate, ntTime);
                notificationModels.add(nm);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return notificationModels;
    }

    public ArrayList<FileStoreModel> getAllFilesByDept(int deptId) {
        ArrayList<FileStoreModel> fileStoreModels = null;
        try {
            fileStoreModels = new ArrayList<>();
            sql = "select * from file_store fs,file_dept_map fdm where fs.id=fdm.fileId and deptId=" + deptId + "";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fileName = rs.getString("fileName");
                String fileSize = rs.getString("fileSize");
                String upDate = rs.getString("upDate");
                String upTime = rs.getString("upTime");
                FileDeptMapModel fdmm = new FileDeptMapModel();
                FileStoreModel fsm = new FileStoreModel(id, fileName, fileSize, upDate, upTime, fdmm);
                fileStoreModels.add(fsm);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return fileStoreModels;
    }

    public String getDeptName(int deptId) {
        String deptName = "";
        try {
            sql = "select deptName from department where id=" + deptId + "";
            rs = getData(sql);
            if (rs.next()) {
                deptName = rs.getString("deptName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptName;

    }

    public String getFileName(int fileId) {
        String fileName = "";
        try {
            sql = "select fileName from file_store where id=" + fileId + "";
            rs = getData(sql);
            if (rs.next()) {
                fileName = rs.getString("fileName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;

    }

    public boolean uploadFile(int deptId, String fileName, int fileSize, String upDate, String upTime) {
        try {

            sql = "insert into file_store values(0,'" + fileName + "','" + fileSize + "','" + upDate + "','" + upTime + "')";
            i = putData(sql);
            if (i > 0) {
                i = 0;
                int fileId = getLastFileId();
                sql = "insert into file_dept_map values(0," + fileId + "," + deptId + ")";
                i = putData(sql);
                if (i > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getLastFileId() {
        int fileId = 0;
        try {
            sql = "select max(id) from file_store";
            rs = getData(sql);
            if (rs.next()) {
                fileId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileId;
    }

    public int getDeptId(int empId) {
        int deptId = 0;
        try {
            sql = "select deptId from emp_dept_map where empId=" + empId + "";
            rs = getData(sql);
            if (rs.next()) {
                deptId = rs.getInt("deptId");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptId;

    }

    public ArrayList<FileStoreModel> getAllFiles() {
        ArrayList<FileStoreModel> fileStoreModels = null;
        try {
            fileStoreModels = new ArrayList<>();
            sql = "select * from file_store fs,file_dept_map fdm where fs.id=fdm.fileId";
            rs = getData(sql);
            while (rs.next()) {
                int fileId = rs.getInt("fs.id");
                String fileName = rs.getString("fileName");
                String fileSize = rs.getString("fileSize");
                String upDate = rs.getString("upDate");
                String upTime = rs.getString("upTime");
                int deptId = rs.getInt("deptId");
                int fdmId = rs.getInt("fdm.id");
                FileDeptMapModel fdmm = new FileDeptMapModel(fdmId, fileId, deptId);
                FileStoreModel fsm = new FileStoreModel(fileId, fileName, fileSize, upDate, upTime, fdmm);
                fileStoreModels.add(fsm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileStoreModels;
    }

    public boolean addChatHistory(ChatHistoryModel chm) {
        try {
            sql = "insert into chat_history values(0," + chm.getFromId() + "," + chm.getToId() + ",'" + chm.getFromUtype() + "','" + chm.getToUtype() + "','" + chm.getMsg() + "','" + chm.getCtDate() + "','" + chm.getCtTime() + "')";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean clearChatHistory() {
        try {
            sql = "delete from chat_history";
            i = putData(sql);
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean scheduleCaptureNow(ScheduleCaptureModel scm) {
        try {
            sql = "select * from schedule_capture where fromTime>='" + scm.getFromTime() + "' and fromTime<='" + scm.getToTime() + "' and scDate='" + scm.getScDate() + "'";
            rs = getData(sql);
            if (!rs.next()) {

                sql = "select * from schedule_capture where '" + scm.getFromTime() + "'>=fromTime and '" + scm.getFromTime() + "' <=toTime  and scDate='" + scm.getScDate() + "'";
                rs = getData(sql);
                if (!rs.next()) {
                    sql = "insert into schedule_capture values (0," + scm.getEmpId() + ",'" + scm.getScDate() + "','" + scm.getFromTime() + "','" + scm.getToTime() + "','requested')";
                    i = putData(sql);
                    if (i > 0) {
                        flag = true;
                    }
                }
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<ScheduleCaptureModel> getAllRequestedScheduleCapture() {
        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = new ArrayList<>();
        try {
            sql = "select * from schedule_capture where status='requested'";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int empId = rs.getInt("empId");
                String scDate = rs.getString("scDate");
                String fromTime = rs.getString("fromTime");
                String toTime = rs.getString("toTime");
                String status = rs.getString("status");
                ScheduleCaptureModel scm = new ScheduleCaptureModel(id, empId, scDate, fromTime, toTime, status);
                scheduleCaptureModels.add(scm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleCaptureModels;
    }

    public ArrayList<ScheduleCaptureModel> getAllScheduledScheduleCapture() {
        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = new ArrayList<>();
        try {
            sql = "select * from schedule_capture where status='scheduled'";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int empId = rs.getInt("empId");
                String scDate = rs.getString("scDate");
                String fromTime = rs.getString("fromTime");
                String toTime = rs.getString("toTime");
                String status = rs.getString("status");
                ScheduleCaptureModel scm = new ScheduleCaptureModel(id, empId, scDate, fromTime, toTime, status);
                scheduleCaptureModels.add(scm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleCaptureModels;
    }

    public ArrayList<ScheduleCaptureModel> getAllRejectedScheduleCapture() {
        ArrayList<ScheduleCaptureModel> scheduleCaptureModels = new ArrayList<>();
        try {
            sql = "select * from schedule_capture where status='rejected'";
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int empId = rs.getInt("empId");
                String scDate = rs.getString("scDate");
                String fromTime = rs.getString("fromTime");
                String toTime = rs.getString("toTime");
                String status = rs.getString("status");
                ScheduleCaptureModel scm = new ScheduleCaptureModel(id, empId, scDate, fromTime, toTime, status);
                scheduleCaptureModels.add(scm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleCaptureModels;
    }

    public boolean updateScheduleCaptureStatus(int id, String status) {
        try {
            sql = "update schedule_capture set status='" + status + "' where id=" + id + "";
            i = putData(sql);
            if (i > 0) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean checkScheduleCapture(int empId, String date, String time) {
        try {
            sql = "select * from schedule_capture where '" + time + "' >=fromTime and '" + time + "'<=toTime and scDate='" + date + "' and status='scheduled'";
            rs = getData(sql);
            if (rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int insertEmpLog(String logName, int empId) {
        int i = 0;
        try {
            sql = "insert into emp_log values(?,?,?,?,?)";
            System.out.println(sql);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, empId);
            ps.setString(3, logName);
            ps.setString(4, DateAndTime.getCurrentDate());
            ps.setString(5, DateAndTime.getCurrentTime());
            i = ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) {
        DbProcess dbProcess = new DbProcess();
//        dbProcess.CreateTables();
        dbProcess.getAllRequestedScheduleCapture();
    }

//    private void CreateTables() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
