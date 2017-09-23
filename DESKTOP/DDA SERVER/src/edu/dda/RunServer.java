/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda;

import edu.dda.nw.ChatServer;
import edu.dda.nw.DDAServer;
import edu.dda.nw.FileServer;
import edu.dda.nw.MouseEventServer;
import edu.dda.nw.ScreenCaptureServer;

/**
 *
 * @author pvr
 */
public class RunServer {

    public static void main(String[] args) {
        DDAServer dDAServer = new DDAServer(1111);
        ChatServer chatServer = new ChatServer(2222);
        FileServer fileServer = new FileServer(3333);
        ScreenCaptureServer s = new ScreenCaptureServer(5555);
        MouseEventServer mes = new MouseEventServer(6666);
    }
}
