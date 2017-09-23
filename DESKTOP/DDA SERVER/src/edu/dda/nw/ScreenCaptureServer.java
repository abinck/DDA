/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.nw;

import edu.dda.utils.ScreenCaptureUtil;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author pvr
 */
public class ScreenCaptureServer implements Runnable {

    ServerSocket ss = null;
    Socket s = null;
// FOR SSH

    static {

        System.setProperty("java.awt.headless", "false");
    }

    public ScreenCaptureServer(int port) {
        try {
            ss = new ServerSocket(port);
            System.out.println("Screen Capture Server Started At Port>>> " + port);
            new Thread(this).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                s = ss.accept();
                System.out.println("Screen Capture Child Connected...");
                new ScreenCaptureChildServer(s).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ScreenCaptureChildServer extends Thread {

        Socket socket = null;
        OutputStream os = null;
        DataOutputStream dos = null;
        Rectangle rectangle = null;
        Robot robot = null;
        ScreenCaptureUtil scu = null;
        ByteArrayOutputStream baos = null;
        BufferedImage image = null;
        int xPosition = 0;
        int yPosition = 0;
        Image mouseCursor = null;
        String cursorPath = File.separator + "edu" + File.separator + "dda" + File.separator + "resources" + File.separator + "cursor.png";
        URL cursorURL = null;

        public ScreenCaptureChildServer(Socket socket) {

            try {

                this.socket = socket;
                scu = new ScreenCaptureUtil();
                rectangle = scu.getScreenSize();
                robot = scu.getCapture();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {

                os = socket.getOutputStream();
                dos = new DataOutputStream(os);
                cursorURL = getClass().getResource(cursorPath);
                while (true) {
                    xPosition = MouseInfo.getPointerInfo().getLocation().x;
                    yPosition = MouseInfo.getPointerInfo().getLocation().y;
                    mouseCursor = ImageIO.read(cursorURL);
                    image = robot.createScreenCapture(rectangle);
                    Graphics2D graphics2D = image.createGraphics();
                    graphics2D.drawImage(mouseCursor, xPosition, yPosition, 16, 16, null);
                    baos = new ByteArrayOutputStream();
                    ImageIO.write(image, "jpg", baos);
                    baos.flush();
                    baos.close();
                    byte[] imageInByte = baos.toByteArray();
                    int count = imageInByte.length;
                    dos.writeInt(count);
                    dos.write(imageInByte);
                    dos.flush();
                    Thread.sleep(500);//Reduces Network Traffic
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        ScreenCaptureServer s = new ScreenCaptureServer(5555);
    }

}
