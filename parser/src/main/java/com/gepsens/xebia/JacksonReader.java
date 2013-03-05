package com.gepsens.xebia;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonReader {

    private static <T extends Object> T readJsonFile(Class<T> clazz, File file) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(file, clazz);
        } catch(Exception e) {
            System.out.println("Couldn't read file " + file.getName() + " : " + e.getMessage());
        }
        return null;
    }
}
