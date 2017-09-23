package edu.dda.nw;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import edu.dda.ChatActivity;
import edu.dda.utils.Variables;

/**
 * Created by pvr on 10/9/16.
 */

public class ChatClient {

    Socket socket = null;
    String email = "";
    public Sender sender = null;
    Receiver receiver = null;


    public ChatClient(String email) {
        try {
            socket = new Socket(Variables.ChatServerIp, Variables.ChatServerPort);
            this.email = email;

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
                        Variables.chatMsg = msg;
                        ChatActivity.PlaceholderFragment.handler.sendMessage(ChatActivity.PlaceholderFragment.handler.obtainMessage());
                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //RECEIVER SUB CLASS END


}


