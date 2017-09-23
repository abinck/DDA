/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pvr
 */
public class MouseEventServer implements Runnable {

    ServerSocket ss = null;
    Socket s = null;

    public MouseEventServer(int port) {
        try {
            ss = new ServerSocket(port);
            System.out.println("Mouse Event Server Started At Port>>> " + port);
            new Thread(this).start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                s = ss.accept();
                System.out.println("Mouse Event Client Connected...");
                new MouseEventChild(s).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    class MouseEventChild extends Thread {

        Socket socket = null;
        InputStream is = null;
        BufferedReader br = null;
        private Robot robot;

        public MouseEventChild(Socket socket) {
            try {
                this.socket = socket;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void run() {
            try {
                is = socket.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                robot = new Robot();

                while (true) {
                    String line = br.readLine();
//                    System.out.println("line = " + line);
                    if (line == null) {
                        break;
                    }
                    if (line.equals("exit")) {

                        is.close();
                        socket.close();
                        break;
                    } else if (line.contains(",")) {
                        float movex = Float.parseFloat(line.split(",")[0]);
                        float movey = Float.parseFloat(line.split(",")[1]);
                        Point point = MouseInfo.getPointerInfo().getLocation();
                        float nowx = point.x;
                        float nowy = point.y;
                        robot.mouseMove((int) (nowx + movex), (int) (nowy + movey));
                    } else if (line.contains("left_click")) {
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    } else if (line.contains("right_click")) {
                        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                    }
                }
                is.close();
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        MouseEventServer mes = new MouseEventServer(6666);
    }

}
