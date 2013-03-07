package com.gepsens.xebia.crawler.local;

import java.util.Objects;
import com.gepsens.xebia.Artist;
import org.junit.Test;
import static junit.framework.Assert.assertNotNull;

public class LocalLastFMParserTest {

    public static final String API_DIR = "./data/lastfm_api";

    public void should_get_dataset() throws Exception {
        LocalLastFMParser localLastFMParser = new LocalLastFMParser(API_DIR);
        LocalDataSet<Artist> dataSet = localLastFMParser.getDataSet(Artist.class);
//        assertNotNull(dataSet);
//        System.out.println(dataSet.getItems().iterator().next());
    }
}
