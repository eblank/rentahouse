package com.tenement.model.constant;

/**
 * Created by LXPENG on 2016/5/19.
 * url类型
 */
public enum UrlTypeEnum {
    HOUSEINFO("houseInfo");

    private String value;

    UrlTypeEnum(String value) {
        this.value = value;
    }

    public static UrlTypeEnum getEnum(String value) {
        for (UrlTypeEnum type : UrlTypeEnum.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
