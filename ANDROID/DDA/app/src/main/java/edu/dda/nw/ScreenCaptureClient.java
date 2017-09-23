package edu.dda.nw;

import java.io.DataInputStream;
import java.net.Socket;

import edu.dda.FullScreenCaptureActivity;
import edu.dda.utils.Variables;

/**
 * Created by pvr on 20/9/16.
 */
public class ScreenCaptureClient extends Thread {
    private Socket socket = null;

    public ScreenCaptureClient() {
        try {
            socket = new Socket(Variables.ScreenCaptureServerIp, Variables.ScreenCaptureServerPort);
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void run() {


        DataInputStream dis = null;

        try {

            dis = new DataInputStream(socket.getInputStream());

            while (true) {
                int packetLength = dis.readInt();
                byte[] data = new byte[packetLength];
                dis.readFully(data, 0, packetLength);
                Variables.capturedImage = data;
                FullScreenCaptureActivity.screenHandler.sendMessage(FullScreenCaptureActivity.screenHandler.obtainMessage());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
