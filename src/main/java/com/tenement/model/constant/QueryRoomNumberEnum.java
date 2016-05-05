package com.tenement.model.constant;

/**
 * Created by LXPENG on 2016/5/5.
 * 卧室数
 */
public enum QueryRoomNumberEnum {
    j1(1),
    j2(2),
    j3(3),
    j4(4),
    j5(5);

    private int value;

    QueryRoomNumberEnum(int value) {
        this.value = value;
    }

    public static QueryRoomNumberEnum getRoomNumber(int value) {
        for (QueryRoomNumberEnum type : QueryRoomNumberEnum.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
