package edu.dda.models;

/**
 * Created by pvr on 8/9/16.
 */
public class FileStoreModel {

    private int id;
    private String fileName;
    private String fileSize;
    private String upDate;
    private String upTime;

    public FileStoreModel() {
    }

    public FileStoreModel(int id, String fileName, String fileSize, String upDate, String upTime) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.upDate = upDate;
        this.upTime = upTime;
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

}
