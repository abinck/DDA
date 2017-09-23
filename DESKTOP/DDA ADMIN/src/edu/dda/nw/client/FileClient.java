/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw.client;

import edu.dda.utils.Variables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author pvr
 */
public class FileClient {

    public static boolean uploadFile(int deptId, String filePath) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.FileServerIp, Variables.FileServerPort);
            OutputStream os = null;
            InputStream is = null;
            BufferedReader br = null;
            PrintStream ps = null;
            FileInputStream fis = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            File file = new File(filePath);
            ps.println("uploadFile");
            ps.println(deptId);
            ps.println(file.getName());
            int fileSize = (int) file.length();
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
            result = Boolean.valueOf(br.readLine().trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        uploadFile(1, "/home/pvr/Desktop/CODES/images.jpg");
    }
}
