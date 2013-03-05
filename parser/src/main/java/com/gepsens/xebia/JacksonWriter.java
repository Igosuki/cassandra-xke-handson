package com.gepsens.xebia;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonWriter {

    private String apiDir;

    private ObjectMapper mapper;

    public JacksonWriter(String apiDir) {
        this.apiDir = apiDir;
        this.mapper = new ObjectMapper();
    }

    public void saveJsonFile(Object object, String dir, String fileName) {
        try {
            File destFile = new File(apiDir + dir, fileName + ".json");
            if(!destFile.exists())
                destFile.createNewFile();
            this.mapper.writeValue(destFile, object);
        } catch(Exception e) {
            System.out.println("Couldn't write file " + fileName + " : " + e.getMessage());
        }
    }
}
