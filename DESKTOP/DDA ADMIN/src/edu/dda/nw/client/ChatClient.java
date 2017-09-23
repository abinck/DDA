/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw.client;

import edu.dda.gui.Chat;
import edu.dda.utils.Variables;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author pvr
 */
public class ChatClient {

    Socket socket = null;
    String email = "";
    public Sender sender = null;
    Receiver receiver = null;
    Chat chat = null;

    public ChatClient(String email, Chat chat) {
        try {
            socket = new Socket(Variables.ChatServerIp, Variables.ChatServerPort);
            this.email = email;
            this.chat = chat;
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //SENDER SUB CLASS START
    public class Sender {

        OutputStream os;
        PrintStream ps;
        Socket sSocket;

        public Sender(Socket sSocket) {
            try {
                this.sSocket = sSocket;
                os = sSocket.getOutputStream();
                ps = new PrintStream(os);
                ps.println(email);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void sendToAll(String msg) {
            try {
                ps.println("sendToAll");
                ps.println(email);
                ps.println(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void sendToOne(String toEmail, String msg) {
            try {
                ps.println("sendToOne");
                ps.println(email);
                ps.println(toEmail);
                ps.println(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //SENDER SUB CLASS END
    //RECEIVER SUB CLASS START

    class Receiver extends Thread {

        Socket rSocket = null;
        InputStream is = null;
        DataInputStream dis = null;

        public Receiver(Socket rSocket) {
            try {
                this.rSocket = rSocket;
                is = rSocket.getInputStream();
                dis = new DataInputStream(is);
                this.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String msg = null;
                while (true) {
                    msg = dis.readLine();
                    if (msg == null) {
                        break;
                    }

                    if (msg.equals("exit")) {
                        break;
                    } else {
                        chat.updateMSG(msg);
                        
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //RECEIVER SUB CLASS END

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("admin", null);
        chatClient.sender.sendToAll("hai");

    }
}
