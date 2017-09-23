/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.models;

/**
 *
 * @author pvr
 */
public class AdminLoginModel {

    private int id;
    private String uname;
    private String passwd;

    public AdminLoginModel() {
    }

    public AdminLoginModel(int id, String uname, String passwd) {
        this.id = id;
        this.uname = uname;
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
