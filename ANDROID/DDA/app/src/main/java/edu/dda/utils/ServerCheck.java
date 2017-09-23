package edu.dda.utils;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by pvr on 6/9/16.
 */
public class ServerCheck {

    public static boolean isServerFound(String ip, int port) {

        boolean flag = false;

        try {

            Socket soc = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(ip, port);
            soc.connect(socketAddress, 5000); // 5 second timeout
            flag = true;

        } catch (Exception e) {
            flag = false;
        }

        return flag;

    }
}
