package com.gepsens.xebia.crawler.lastfm;

import java.io.File;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;

public class LastFMJsonHDF5Processor {
    public static void processLastFmJsonFiles(String rootDir) throws Exception {
        File dataDir = new File(rootDir);

        File[] files = dataDir.listFiles();
        startFileRecurse(files);
    }

    private static void startFileRecurse(File[] files) throws Exception {
        for (File file : files) {
            if(LastFMApiParser.counter > LastFMApiParser.MAX_SONGS)
                break;
            if(file.isDirectory()) {
                startFileRecurse(file.listFiles());
            } else {
                if(file.getName().endsWith("json")) {
                    parseLastFMJson(file);
                }
            }
        }
    }

    private static void parseLastFMJson(File file) throws Exception {
        JsonFactory f = new MappingJsonFactory();
        JsonParser jp = f.createJsonParser(file);

        JsonToken current;

        current = jp.nextToken();
        if (current != JsonToken.START_OBJECT) {
            System.out.println("Error: root should be object: quiting.");
            return;
        }

        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();
            current = jp.nextToken();
            if (fieldName.equals("records")) {
                if (current == JsonToken.START_ARRAY) {
                    while (jp.nextToken() != JsonToken.END_ARRAY) {
                        JsonNode node = jp.readValueAsTree();
                        System.out.println("field1: " + node.get("field1").asText());
                        System.out.println("field2: " + node.get("field2").asText());
                    }
                } else {
                    System.out.println("Error: records should be an array: skipping.");
                    jp.skipChildren();
                }
            } else {
                System.out.println("Unprocessed property: " + fieldName);
                jp.skipChildren();
            }
        }
    }
}
