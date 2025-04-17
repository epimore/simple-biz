package cn.epimore.gmv.api.model;

public class RecordingInfo {
    private String fileName;
    private Long fileSize;
    private long timestamp;
    private Integer bytesSec;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getBytesSec() {
        return bytesSec;
    }

    public void setBytesSec(Integer bytesSec) {
        this.bytesSec = bytesSec;
    }
}
