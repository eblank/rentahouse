package com.tenement.model;

import com.tenement.model.constant.DataStatus;

public class Url {
    private Long id;

    private String url;

    private String urlMd5;

    private String urlType;

    private Long status;

    public Url() {
        status = DataStatus.OPEN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUrlMd5() {
        return urlMd5;
    }

    public void setUrlMd5(String urlMd5) {
        this.urlMd5 = urlMd5 == null ? null : urlMd5.trim();
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType == null ? null : urlType.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}