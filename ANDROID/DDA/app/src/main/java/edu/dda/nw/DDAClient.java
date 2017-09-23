package edu.dda.nw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import edu.dda.models.ChatHistoryModel;
import edu.dda.models.FileStoreModel;
import edu.dda.models.NotificationModel;
import edu.dda.utils.Variables;

/**
 * Created by pvr on 6/9/16.
 */
public class DDAClient {
    public static int empLogin(String email, String passwd)

    {
        int empId = 0;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader bufferedReader = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(outputStream);
            printStream.println("empLogin");
            printStream.println(email);
            printStream.println(passwd);
            empId = Integer.valueOf(bufferedReader.readLine().trim());
            printStream.println("exit");
            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return empId;
    }

    public static boolean empLogout()

    {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.DDAServerIp, Variables.DDAServerPort);
            BufferedReader bufferedReader = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(outputStream);
            printStream.println("empLogout");
            printStream.println(Variables.sessionId);
            result = Boolean.valueOf(bufferedReader.readLine().trim());
            printStream.println("exit");
            inputStream.close();
            outputStream.close();

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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return notificationModels;
    }

    public static ArrayList<ChatHistoryModel> getEmpChatHistory() {
        ArrayList<ChatHistoryModel> chatHistoryModels = new ArrayList<>();

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
            printStream.println("getEmpChatHistory");
            printStream.println(Variables.sessionId);
            String allChatHistory = br.readLine().trim().replace("[", "").replace("]", "");
            printStream.println("exit");
            String notifications[] = allChatHistory.split(",");
            for (int i = 0; i < notifications.length; i++) {
                String history[] = notifications[i].split("#");
                int id = Integer.parseInt(history[0].trim());
                int fromId = Integer.parseInt(history[1].trim());
                int toId = Integer.parseInt(history[2].trim());
                String fromUtype = history[3].trim();
                String toUtype = history[4].trim();
                String msg = history[5].trim();
                String ctDate = history[6].trim();
                String ctTime = history[7].trim();
                ChatHistoryModel ctm = new ChatHistoryModel(id, fromId, toId, fromUtype, toUtype, msg, ctDate, ctTime);
                chatHistoryModels.add(ctm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chatHistoryModels;
    }

    public static ArrayList<FileStoreModel> getAllFilesByDept() {
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
            printStream.println("getAllFilesByDept");
            printStream.println(Variables.sessionId);
            String allFiles = br.readLine().trim().replace("[", "").replace("]", "");
            printStream.println("exit");
            String files[] = allFiles.split(",");
            for (int i = 0; i < files.length; i++) {
                String noti[] = files[i].split("#");
                int id = Integer.parseInt(noti[0].trim());
                String fileName = noti[1].trim();
                String fileSize = noti[2].trim();
                String upDate = noti[3].trim();
                String upTime = noti[4].trim();
                FileStoreModel fsm = new FileStoreModel(id, fileName, fileSize, upDate, upTime);
                fileStoreModels.add(fsm);
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

    public static boolean scheduleNow(String date, String fromTime, String toTime) {
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
            printStream.println("scheduleNow");
            printStream.println(Variables.sessionId);
            printStream.println(date);
            printStream.println(fromTime);
            printStream.println(toTime);
            result = Boolean.valueOf(br.readLine().trim());
            printStream.println("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean checkCaptureSchedule() {
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
            printStream.println("checkCaptureSchedule");
            printStream.println(Variables.sessionId);
            result = Boolean.valueOf(br.readLine().trim());
            printStream.println("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
