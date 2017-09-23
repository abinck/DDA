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
public class ChatHistoryModel {

    private int id;
    private int fromId;
    private int toId;
    private String fromUtype;
    private String toUtype;
    private String msg;
    private String ctDate;
    private String ctTime;

    public ChatHistoryModel() {
    }

    public ChatHistoryModel(int id, int fromId, int toId, String fromUtype, String toUtype, String msg, String ctDate, String ctTime) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.fromUtype = fromUtype;
        this.toUtype = toUtype;
        this.msg = msg;
        this.ctDate = ctDate;
        this.ctTime = ctTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public String getFromUtype() {
        return fromUtype;
    }

    public void setFromUtype(String fromUtype) {
        this.fromUtype = fromUtype;
    }

    public String getToUtype() {
        return toUtype;
    }

    public void setToUtype(String toUtype) {
        this.toUtype = toUtype;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCtDate() {
        return ctDate;
    }

    public void setCtDate(String ctDate) {
        this.ctDate = ctDate;
    }

    public String getCtTime() {
        return ctTime;
    }

    public void setCtTime(String ctTime) {
        this.ctTime = ctTime;
    }

    public String toString() {
        return id + "#" + fromId + "#" + toId + "#" + fromUtype + "#" + toUtype + "#" + msg + "#" + ctDate + "#" + ctTime + "#";
    }
}
