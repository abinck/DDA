/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw.server;

import edu.dda.gui.AdminHome;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author pvr
 */
public class RequestServer implements Runnable {

    public ServerSocket serverSocket = null;
    public Socket socket = null;

    public RequestServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Request Server Started At Port>>>" + port);
            new Thread(this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                socket = serverSocket.accept();
                new RequestChild(socket).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class RequestChild extends Thread {

        Socket s = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        PrintStream ps = null;

        public RequestChild(Socket s) {
            try {
                this.s = s;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                is = s.getInputStream();
                os = s.getOutputStream();
                br = new BufferedReader(new InputStreamReader(is));
                ps = new PrintStream(os);

                while (true) {
                    String msg = br.readLine();
                    if (msg == null) {
                        break;
                    }
                    if (msg.equals("exit")) {
                        break;
                    } else if (msg.equals("requestCapture")) {
                        int empId = Integer.parseInt(br.readLine());
                        int status = JOptionPane.showConfirmDialog(null, "Screen Capture Is Requested By>>>EMP ID:-" + empId);
                        if (status == 0) {
                            ps.println(true);
                        } else if ((status == 1) | (status == 2)) {
                            ps.println(false);
                        }
                    }
                }
                is.close();
                os.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        RequestServer requestServer = new RequestServer(4444);
    }

}
