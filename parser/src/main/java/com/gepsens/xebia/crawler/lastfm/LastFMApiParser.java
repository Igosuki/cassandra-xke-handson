package com.gepsens.xebia.crawler.lastfm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LastFMApiParser {

    public String subsetDir;

    public String apiDir;

    public LastFMApiParser(String subsetDir, String apiDir) {
        this.subsetDir = subsetDir;
        this.apiDir = apiDir;
    }

    public void parseLastFMData() throws IOException {

        //LastFMJsonHDF5Processor.processLastFmJsonFiles(subsetDir);

        Properties lastfm = new Properties();
        InputStream resourceAsStream = LastFMApiParser.class.getResourceAsStream("/lastfm.properties");
        lastfm.load(resourceAsStream);
        String key = (String) lastfm.get("key");
        String secret = (String) lastfm.get("secret");
        String user = (String) lastfm.get("user");
        if(key == null) {
            throw new IllegalStateException("Lastfm property key needed");
        } else {
            System.out.println(key);
            System.out.println(secret);
        }
        new LastFMApiProcessor(apiDir, user, key, secret).downloadFromLastFM();
        //printFileNameAsHexStrings();
    }
}
