package edu.dda.nw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import edu.dda.utils.Variables;

/**
 * Created by pvr on 29/9/16.
 */
public class RequestClient {
    public static boolean requestCapture() {
        boolean result = false;
        try {

            Socket socket = new Socket(Variables.RequestServerIp, Variables.RequestServerPort);
            BufferedReader br = null;
            PrintStream printStream = null;
            InputStream inputStream = null;
            OutputStream os = null;
            inputStream = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            printStream = new PrintStream(os);
            printStream.println("requestCapture");
            printStream.println(Variables.sessionId);
            result = Boolean.valueOf(br.readLine().trim());
            printStream.println("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
