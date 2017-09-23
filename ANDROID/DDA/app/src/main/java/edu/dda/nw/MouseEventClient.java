package edu.dda.nw;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import edu.dda.utils.Variables;

/**
 * Created by pvr on 21/9/16.
 */
public class MouseEventClient {
    OutputStream os = null;
    PrintWriter pw = null;

    public MouseEventClient() {
        try {

            Socket socket = new Socket(Variables.MouseEventServerIP, Variables.MouseEventServerPort);
            os = socket.getOutputStream();
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)), true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveMouse(float xDistance, float yDistance) {
        try {

            pw.println(xDistance + "," + yDistance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leftClickMouse() {
        try {

            pw.println("left_click");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rightClickMouse() {
        try {

            pw.println("right_click");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
