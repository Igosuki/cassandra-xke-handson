package com.gepsens.xebia.crawler.local;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

class LocalLastFMApiProcessor {

    private final ObjectMapper mapper;

    public LocalLastFMApiProcessor() {
        this.mapper = new ObjectMapper();
    }

    public <T extends Object> T parseLastFMJson(Class<T> clazz, File file) {
        try {
            return this.mapper.readValue(file, clazz);
        } catch (IOException e) {
            System.out.println("Couldn't read json file : " + e.getMessage());
        }
        return null;
    }
}
