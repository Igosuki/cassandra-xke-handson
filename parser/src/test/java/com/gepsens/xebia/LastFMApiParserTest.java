package com.gepsens.xebia;

import java.io.IOException;
import com.gepsens.xebia.crawler.lastfm.LastFMApiParser;
import org.junit.Before;
import org.junit.Test;

public class LastFMApiParserTest {

    private LastFMApiParser parser;

    @Before
    public void setup() {
        parser = new LastFMApiParser("./data/lastfm_subset", "./data/lastfm_api");
    }

    public void downloadLastFMApi() throws IOException {
        parser.parseLastFMData();
    }



}
