package com.tenement.model;

import java.util.Date;

public class CaptchaCode {
    private Long id;

    private String code;

    private Date createTime;

    private Date invalidTime;

    private String userAccount;

    private boolean validated;

    private Date validatedTime;

    private String email;

    public CaptchaCode() {
    }

    public CaptchaCode(String code, Date createTime, Date invalidTime, String userAccount, String email, boolean validated) {
        this.code = code;
        this.createTime = createTime;
        this.invalidTime = invalidTime;
        this.userAccount = userAccount;
        this.email = email;
        this.validated = validated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Date getValidatedTime() {
        return validatedTime;
    }

    public void setValidatedTime(Date validatedTime) {
        this.validatedTime = validatedTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}