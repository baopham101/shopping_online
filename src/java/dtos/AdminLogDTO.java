package dtos;

import java.sql.Timestamp;

public class AdminLogDTO {
    private int logID;
    private String email;
    private String action;
    private Timestamp logDate;

    public AdminLogDTO() {
    }

    public AdminLogDTO(int logID, String email, String action, Timestamp logDate) {
        this.logID = logID;
        this.email = email;
        this.action = action;
        this.logDate = logDate;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getLogDate() {
        return logDate;
    }

    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }
}
