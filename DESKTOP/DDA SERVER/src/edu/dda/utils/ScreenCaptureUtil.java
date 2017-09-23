/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.utils;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

/**
 *
 * @author pvr
 */
public class ScreenCaptureUtil {

    public Rectangle getScreenSize() {

        Rectangle rectangle = null;

        try {

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            rectangle = new Rectangle(dim);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rectangle;
    }

    public Robot getCapture() {
        Robot robot = null;
        try {
            GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
            robot = new Robot(gDev);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return robot;

    }
}
