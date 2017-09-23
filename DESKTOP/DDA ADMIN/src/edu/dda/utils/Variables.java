/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.utils;

import edu.dda.nw.client.ChatClient;

/**
 *
 * @author pvr
 */
public class Variables {

    private static String ipAddress = "localhost";
    public static String DDAServerIp = ipAddress;
    public static String ChatServerIp = ipAddress;
    public static String FileServerIp = ipAddress;
    public static int DDAServerPort = 1111;
    public static int ChatServerPort = 2222;
    public static int FileServerPort = 3333;
     public static int RequestServerPort = 4444; 
    public static boolean employeeFormOpenStatus = false;
    public static ChatClient chatClient = null;

}
