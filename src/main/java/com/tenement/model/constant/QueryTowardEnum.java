package com.tenement.model.constant;

/**
 * Created by LXPENG on 2016/5/5.
 * 朝向
 */
public enum QueryTowardEnum {
    d1("东"),
    d2("南"),
    d3("西"),
    d4("北"),
    d5("南北"),
    d6("东西"),
    d7("东南"),
    d8("西南"),
    d9("东北"),
    d10("西北");

    private String value;

    QueryTowardEnum(String value) {
        this.value = value;
    }

    public static QueryTowardEnum getRoomNumber(String value) {
        for (QueryTowardEnum type : QueryTowardEnum.values()) {
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
