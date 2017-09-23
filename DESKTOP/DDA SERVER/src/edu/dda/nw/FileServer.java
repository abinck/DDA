/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw;

import edu.dda.db.DbProcess;
import edu.dda.utils.DateAndTime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pvr
 */
public class FileServer implements Runnable {

    ServerSocket serverSocket = null;
    Socket socket = null;
    DbProcess dbProcess = null;

    public FileServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("File Server Started At Port " + port);
            new Thread(this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected");
                new FileChild(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class FileChild extends Thread {

        Socket s;
        InputStream is = null;
        OutputStream os = null;
        PrintStream ps = null;
        BufferedReader br = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;

        public FileChild(Socket s) {
            try {
                this.s = s;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                is = s.getInputStream();
                os = s.getOutputStream();
                ps = new PrintStream(os);
                br = new BufferedReader(new InputStreamReader(is));

                while (true) {
                    String msg = br.readLine();
                    if (msg == null) {
                        break;
                    }
                    if (msg.equals("exit")) {
                        break;
                    } else if (msg.equals("uploadFile")) {
                        int deptId = Integer.parseInt(br.readLine());
                        String fileName = br.readLine();
                        int fileSize = Integer.parseInt(br.readLine());
                        dbProcess = new DbProcess();
                        String deptName = dbProcess.getDeptName(deptId);
                        String outPath = "FileStore" + File.separator + deptName + File.separator;
                        File file = new File(outPath);
                        file.mkdirs();
                        file = new File(outPath + fileName);
                        int count = 0, ch = 0;
                        fos = new FileOutputStream(file);
                        byte b[] = new byte[1024];
                        while ((ch = is.read(b)) != -1) {
                            count += ch;
                            fos.write(b, 0, ch);
                            if (count >= fileSize) {
                                break;
                            }
                        }
                        fos.close();
                        String upDate = DateAndTime.getCurrentDate();
                        String upTime = DateAndTime.getCurrentTime();
                        boolean result = dbProcess.uploadFile(deptId, fileName, fileSize, upDate, upTime);
                        ps.println(result);
                    } else if (msg.equals("downloadFile")) {
                        int empId = Integer.parseInt(br.readLine().trim());
                        int fileId = Integer.parseInt(br.readLine().trim());
                        dbProcess = new DbProcess();
                        int deptId = dbProcess.getDeptId(empId);
                        String deptName = dbProcess.getDeptName(deptId);
                        String fileName = dbProcess.getFileName(fileId);
                        dbProcess.insertEmpLog("File Downloaded: " + fileName, empId);
                        String filePath = "FileStore" + File.separator + deptName + File.separator + fileName;
                        File file = new File(filePath);
                        if (!file.exists()) {
                            ps.println(false);
                        } else {
                            int fileSize = (int) file.length();
                            ps.println(true);
                            ps.println(fileName);
                            ps.println(fileSize);

                            int ch = 0, cnt = 0;
                            byte b[] = new byte[1024];
                            Thread.sleep(300);
                            fis = new FileInputStream(file);
                            while ((ch = fis.read(b)) != -1) {
                                os.write(b, 0, ch);
                                cnt += ch;
                                if (cnt >= fileSize) {
                                    break;
                                }
                            }
                            fis.close();

                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        FileServer fileServer = new FileServer(3333);
    }
}
