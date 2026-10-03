package com.karur.mcp_site_management_server.util;

import tools.jackson.databind.json.JsonMapper;

import java.util.Objects;

public class CommonUtil {

    public static final JsonMapper JSON_MAPPER = new JsonMapper();

    public static String toString(Object object) {
        if (Objects.isNull(object)) return null;
        return JSON_MAPPER.writeValueAsString(object);
    }
}
