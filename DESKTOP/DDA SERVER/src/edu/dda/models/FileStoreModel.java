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
public class FileStoreModel {

    private int id;
    private String fileName;
    private String fileSize;
    private String upDate;
    private String upTime;
    private FileDeptMapModel deptMapModel;

    public FileStoreModel() {
    }

    public FileStoreModel(int id, String fileName, String fileSize, String upDate, String upTime, FileDeptMapModel deptMapModel) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.upDate = upDate;
        this.upTime = upTime;
        this.deptMapModel = deptMapModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public FileDeptMapModel getDeptMapModel() {
        return deptMapModel;
    }

    public void setDeptMapModel(FileDeptMapModel deptMapModel) {
        this.deptMapModel = deptMapModel;
    }

    public String toString() {
        return id + "#" + fileName + "#" + fileSize + "#" + upDate + "#" + upTime + "#" + deptMapModel.getDeptId() + "#";
    }

}
