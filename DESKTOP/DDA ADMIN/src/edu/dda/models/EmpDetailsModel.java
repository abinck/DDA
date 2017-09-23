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
public class EmpDetailsModel {

    private int id;
    private String fname;
    private String lname;
    private String phone;
    private EmpLoginModel loginModel;
    private EmpDeptMapModel mapModel;

    public EmpDetailsModel() {
    }

    public EmpDetailsModel(int id, String fname, String lname, String phone, EmpLoginModel loginModel, EmpDeptMapModel mapModel) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.loginModel = loginModel;
        this.mapModel = mapModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmpLoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(EmpLoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public EmpDeptMapModel getMapModel() {
        return mapModel;
    }

    public void setMapModel(EmpDeptMapModel mapModel) {
        this.mapModel = mapModel;
    }

    public String toString() {
        return id + "#" + fname + "#" + lname + "#" + phone + "#" + loginModel.getEmail() + "#" + loginModel.getStatus() + "#" + loginModel.getSessionStatus() + "#" + mapModel.getDeptId() + "#";
    }
}
