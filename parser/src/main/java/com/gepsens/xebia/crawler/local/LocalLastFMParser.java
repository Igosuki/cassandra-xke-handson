package com.gepsens.xebia.crawler.local;

public class LocalLastFMParser {

    public static String subsetDir;

    public static String apiDir;

    public static void main(String[] args) throws Exception {

        subsetDir = args.length > 0 ? args[0] : "./data/lastfm_subset";
        apiDir = "./data/lastfm_api";
        String artistDir = apiDir + "/artists";
        String trackDir = apiDir + "/trackDir";


    }
}
