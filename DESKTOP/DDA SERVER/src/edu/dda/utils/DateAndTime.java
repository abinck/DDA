/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pvr
 */
public class DateAndTime {

    private static Date date = new Date();
    private static SimpleDateFormat simpleDateFormat;
    private static String current_date, current_time;

    public static String getCurrentDate() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        current_date = simpleDateFormat.format(date);
        System.out.println("current_date = " + current_date);
        return current_date;
    }

    public static String getCurrentTime() {
        simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        current_time = simpleDateFormat.format(date);
        System.out.println("current_time= " + current_time);
        return current_time;
    }

    public static void main(String[] args) {
        getCurrentDate();
        getCurrentTime();
    }
}
