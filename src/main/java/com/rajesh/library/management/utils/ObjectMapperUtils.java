package com.rajesh.library.management.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils<T> {
    static ObjectMapper objectMapper = new ObjectMapper();
    public static String getString(Object data){
        try {
            return objectMapper.writeValueAsString(data);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
