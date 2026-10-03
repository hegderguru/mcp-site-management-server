package com.karur.mcp_site_management_server.mapper.util;

import com.karur.mcp_site_management_server.util.CommonUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

public class UpdateUtil {

    public <T> void update(List<T> exitingList, T update){
        List<T> list = exitingList.stream().filter(t -> t.equals(update)).toList();
        if(list.size()>1){
            throw new RuntimeException("duplicates found for %s".formatted(CommonUtil.toString(update)));
        }
    }

    public <T> void update(T existing, T update) {
        if (existing == null || update == null) {
            return;
        }
        if (!existing.getClass().equals(update.getClass())) {
            throw new IllegalArgumentException("Objects must be of the exact same class");
        }

        Class<?> clazz = existing.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                continue;
            }
            if (isSimpleType(field.getType())) {
                try {
                    field.setAccessible(true);
                    Object updateValue = field.get(update);
                    if (updateValue != null) {
                        field.set(existing, updateValue);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to update field: " + field.getName(), e);
                }
            }
        }
    }

    private boolean isSimpleType(Class<?> type) {
        return type.isPrimitive() ||
                type == String.class ||
                type == Integer.class ||
                type == Long.class ||
                type == Double.class ||
                type == Float.class ||
                type == Boolean.class ||
                type == Character.class ||
                type == Byte.class ||
                type == Short.class ||
                type.isEnum();
    }
}
