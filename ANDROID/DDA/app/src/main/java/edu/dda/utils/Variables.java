package edu.dda.utils;

import edu.dda.nw.ChatClient;

/**
 * Created by pvr on 6/9/16.
 */
public class Variables {
    private static String ipAddress = "192.168.1.60";
    public static String DDAServerIp = ipAddress;
    public static String ChatServerIp = ipAddress;
    public static String FileServerIp = ipAddress;
    public static String RequestServerIp = ipAddress;
    public static String ScreenCaptureServerIp = ipAddress;
    public static String MouseEventServerIP = ipAddress;
    public static int DDAServerPort = 1111;
    public static int ChatServerPort = 2222;
    public static int FileServerPort = 3333;
    public static int RequestServerPort = 4444;
    public static int ScreenCaptureServerPort = 5555;
    public static int MouseEventServerPort = 6666;
    public static int sessionId = 0;
    public static String sessionEmail = "";
    public static ChatClient chatClient = null;
    public static String chatMsg = "";
    public static byte[] capturedImage;

}
