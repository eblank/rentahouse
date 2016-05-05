package com.tenement.model.constant;

/**
 * Created by LXPENG on 2016/5/5.
 * 装修程度
 */
public enum  QueryDecorationEnum {
    f1("毛胚"),
    f2("简单装修"),
    f3("中等装修"),
    f4("精装修"),
    f5("豪华装修");

    private String value;

    QueryDecorationEnum(String value) {
        this.value = value;
    }

    public static QueryDecorationEnum getDecoration(String value) {
        for (QueryDecorationEnum type : QueryDecorationEnum.values()) {
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
