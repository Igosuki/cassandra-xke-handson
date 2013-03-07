package com.gepsens.xebia.crawler.local;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import com.gepsens.xebia.FileNameUtil;

public class LocalLastFMParser {

    public String apiDir;

    public LocalLastFMParser(String apiDir) {
        this.apiDir = apiDir;
    }

    public <T extends Object> LocalDataSet<T> getDataSet(Class<T> dataType) throws Exception {
        String dirNameForClass = FileNameUtil.getDirNameForClass(dataType);
        File directory = new File(this.apiDir + "/" + dirNameForClass);
        Set<T> ts = processDirectory(dataType, directory);
        return new LocalDataSet<>(ts);
    }

    private <T extends Object> Set<T> processDirectory(Class<T> type, File directory) throws Exception {
        Set<T> objects = null;
        if(directory.exists()) {
            objects = startFileRecurse(type, directory.listFiles());
        }
        return objects;
    }

    private <T extends Object> Set<T> startFileRecurse(Class<T> fileTypes, File[] files) throws Exception {
        LocalLastFMApiProcessor localLastFMApiProcessor = new LocalLastFMApiProcessor();
        Set<T> returnList = new HashSet<>();
        for (File file : files) {
            if(file.isDirectory()) {
                returnList.addAll(startFileRecurse(fileTypes, file.listFiles()));
            } else {
                if(file.getName().endsWith("json")) {
                    returnList.add(localLastFMApiProcessor.parseLastFMJson(fileTypes, file));
                }
            }
        }
        return returnList;
    }
}
