package com.karur.mcp_site_management_server.util;

import tools.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonUtil {

    public static final JsonMapper JSON_MAPPER = new JsonMapper();

    public static String toString(Object object) {
        if (Objects.isNull(object)) return null;
        return JSON_MAPPER.writeValueAsString(object);
    }

    public static <T> List<T> returnElseEmpty(List<T> list){
        if(Objects.isNull(list)) return new ArrayList<>();
        return list;
    }
}
