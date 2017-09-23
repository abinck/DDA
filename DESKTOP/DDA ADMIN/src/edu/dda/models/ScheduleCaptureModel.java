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
public class ScheduleCaptureModel {

    private int id;
    private int empId;
    private String scDate;
    private String fromTime;
    private String toTime;
    private String status;

    public ScheduleCaptureModel() {
    }

    public ScheduleCaptureModel(int id, int empId, String scDate, String fromTime, String toTime, String status) {
        this.id = id;
        this.empId = empId;
        this.scDate = scDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getScDate() {
        return scDate;
    }

    public void setScDate(String scDate) {
        this.scDate = scDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
