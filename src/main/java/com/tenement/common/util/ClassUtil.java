package com.tenement.common.util;

import com.tenement.model.User;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by LXPENG on 2016/4/22.
 * 类工具
 *
 */
public class ClassUtil {
    /**
     * 给model为null的属性赋值默认值
     * string ""
     * Long int double 0
     * boolean true
     *
     * @param model
     */
    public static void setDefaultValues(Object model) {
        try {
            Field[] fields = model.getClass().getDeclaredFields();
            for (Field field : fields) {
                //id不需要设置默认值
                if ("id".equals(field.getName())) {
                    continue;
                }
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), model.getClass());
                String type = field.getGenericType().toString();
                Method getMethod = propertyDescriptor.getReadMethod();//get方法
                Method setMethod = propertyDescriptor.getWriteMethod();//set方法

                if ("class java.lang.String".equals(type)) {
                    String value = (String) getMethod.invoke(model);
                    if (value == null) {
                        setMethod.invoke(model, "");
                    }
                } else if ("class java.lang.Integer".equals(type)) {
                    Integer value = (Integer) getMethod.invoke(model);
                    if (value == null) {
                        setMethod.invoke(model, 0);
                    }
                } else if ("class java.lang.Double".equals(type)) {
                    Double value = (Double) getMethod.invoke(model);
                    if (value == null) {
                        setMethod.invoke(model, 0);
                    }
                } else if ("class java.lang.Long".equals(type)) {
                    Long value = (Long) getMethod.invoke(model);
                    if (value == null) {
                        setMethod.invoke(model, 1L);
                    }
                } else if ("class java.lang.Boolean".equals(type)) {
                    Boolean value = (Boolean) getMethod.invoke(model);
                    if (value == null) {
                        setMethod.invoke(model, true);
                    }
                } else if ("class java.lang.Date".equals(type)) {
                    Date value = (Date) getMethod.invoke(model);
                    if (value == null) {
                        setMethod.invoke(model, new Date());
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User user = new User("1292002150@qq.com", new Date(), "hurry", "1111");
        ClassUtil.setDefaultValues(user);
        System.out.println(user.toString());
    }
}
