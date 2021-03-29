package cn.pji.car.domain;

public class UploadResult {
    private int status;
    private String filePath;
    private UploadError error;
    private String id;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setError(UploadError error) {
        this.error = error;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public String getFilePath() {
        return filePath;
    }

    public UploadError getError() {
        return error;
    }

    public String getId() {
        return id;
    }
}
