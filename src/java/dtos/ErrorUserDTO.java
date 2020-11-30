/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author baoph
 */
public class ErrorUserDTO {
    private String errorEmail, errorName, errorPassword, errorRole;

    public ErrorUserDTO() {
    }

    public ErrorUserDTO(String errorEmail, String errorName, String errorPassword, String errorRole) {
        this.errorEmail = errorEmail;
        this.errorName = errorName;
        this.errorPassword = errorPassword;
        this.errorRole = errorRole;
    }

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }

    public String getErrorRole() {
        return errorRole;
    }

    public void setErrorRole(String errorRole) {
        this.errorRole = errorRole;
    }
}
