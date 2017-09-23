package edu.dda.nw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import edu.dda.utils.Variables;

/**
 * Created by pvr on 8/9/16.
 */
public class FileClient {

    public static boolean downloadFile(int empId, int fileId, String savePath) {
        boolean result = false;
        try {
            Socket socket = new Socket(Variables.FileServerIp, Variables.FileServerPort);
            InputStream is = null;
            OutputStream os = null;
            BufferedReader br = null;
            PrintStream ps = null;
            FileOutputStream fos = null;
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            ps = new PrintStream(os);
            ps.println("downloadFile");
            ps.println(empId);
            ps.println(fileId);
            result = Boolean.valueOf(br.readLine().trim());
            if (result) {
                String fileName = br.readLine().trim();
                int fileSize = Integer.parseInt(br.readLine().trim());
                savePath = savePath + File.separator + "DDA" + File.separator + "FileStore" + File.separator;
                File file = new File(savePath);
                file.mkdirs();
                file = new File(savePath + fileName);
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

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
