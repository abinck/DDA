package edu.dda.models;

/**
 * Created by pvr on 7/9/16.
 */
public class NotificationModel {
    private int id;
    private String msgName;
    private String msg;
    private String ntDate;
    private String ntTime;

    public NotificationModel() {
    }

    public NotificationModel(int id, String msgName, String msg, String ntDate, String ntTime) {
        this.id = id;
        this.msgName = msgName;
        this.msg = msg;
        this.ntDate = ntDate;
        this.ntTime = ntTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNtDate() {
        return ntDate;
    }

    public void setNtDate(String ntDate) {
        this.ntDate = ntDate;
    }

    public String getNtTime() {
        return ntTime;
    }

    public void setNtTime(String ntTime) {
        this.ntTime = ntTime;
    }

    @Override
    public String toString() {
        return id + "#" + msgName + "#" + msg + "#" + ntDate + "#" + ntTime + "#";
    }

}
