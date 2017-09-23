/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author pvr
 */
public class ChatServer implements Runnable {

    ServerSocket serverSocket = null;
    Socket socket = null;
    HashMap<String, PrintStream> outMap = new HashMap<>();
    ArrayList<PrintStream> outList = new ArrayList<>();

    public ChatServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat Server Started At Port " + port);
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
                new ChatChild(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class ChatChild extends Thread {

        Socket s = null;
        BufferedReader br = null;
        PrintStream ps = null;
        InputStream is = null;
        OutputStream os = null;

        public ChatChild(Socket s) {
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
                br = new BufferedReader(new InputStreamReader(is));
                ps = new PrintStream(os);
                String msg = "";
                msg = br.readLine();
                outMap.put(msg, ps);
                outList.add(ps);
                while (true) {
                    msg = br.readLine();
                    if (msg == null) {
                        break;
                    }
                    if (msg.equals("exit")) {
                        break;
                    } else if (msg.equals("sendToAll")) {
                        String email = br.readLine();
                        String message = br.readLine();
                        sendToAll(email, message);
                    } else if (msg.equals("sendToOne")) {

                        String email = br.readLine();
                        String toEmail = br.readLine();
                        String message = br.readLine();
                        sendToOne(email, toEmail, message);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendToAll(String email, String msg) {

        try {
            for (PrintStream ps : outList) {

                ps.println("[public]" + email + ">>" + msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendToOne(String email, String toEmail, String msg) {

        try {
            PrintStream ps = outMap.get(toEmail);
            ps.println(email + "<<<" + msg);
            ps = outMap.get(email);
            ps.println("ME" + ">>>" + msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(2222);
    }
}
