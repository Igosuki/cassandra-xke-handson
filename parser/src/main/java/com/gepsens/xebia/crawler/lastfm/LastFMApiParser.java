package com.gepsens.xebia.crawler.lastfm;

import java.util.Properties;

public class LastFMApiParser {

    public static String subsetDir;

    public static String apiDir;

    public static void main(String[] args) throws Exception {

        subsetDir = args.length > 0 ? args[0] : "./data/lastfm_subset";
        apiDir = "./data/lastfm_api";
        //LastFMJsonHDF5Processor.processLastFmJsonFiles(subsetDir);

        Properties lastfm = new Properties();
        lastfm.load(LastFMApiParser.class.getResourceAsStream("lastfm.properties"));
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
