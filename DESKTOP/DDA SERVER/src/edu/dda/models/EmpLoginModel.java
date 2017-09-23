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
public class EmpLoginModel {

    private int id;
    private String email;
    private String passwd;
    private String status;
    private String sessionStatus;

    public EmpLoginModel() {
    }

    public EmpLoginModel(int id, String email, String passwd, String status, String sessionStatus) {
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.status = status;
        this.sessionStatus = sessionStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

}
