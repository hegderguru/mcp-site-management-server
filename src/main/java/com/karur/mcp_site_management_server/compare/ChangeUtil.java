package com.karur.mcp_site_management_server.compare;

public class ChangeUtil {

    public static String getStringElseConvert(CompareUtil.Change change) {
        if (change.getRightValue() instanceof String) {
            return (String) change.getRightValue();
        }
        return change.getRightValue().toString();
    }

    public static Integer getIntegerElseConvert(CompareUtil.Change change) {
        if (change.getRightValue() instanceof Integer) {
            return (Integer) change.getRightValue();
        }
        return Integer.parseInt(getStringElseConvert(change));
    }

    public static Boolean getBooleanElseConvert(CompareUtil.Change change) {
        if (change.getRightValue() instanceof Boolean) {
            return (Boolean) change.getRightValue();
        }
        return Boolean.valueOf(getStringElseConvert(change)).equals(true);
    }
}
