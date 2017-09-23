/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.utils;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pvr
 */
public class CheckPortAvailability {

    public static boolean isPortAvailable(int portNumber) {
        boolean result;

        try {

            ServerSocket ss = new ServerSocket(portNumber);
            ss.close();
            result = true;

        } catch (Exception e) {
            result = false;
        }

        return (result);
    }
}
