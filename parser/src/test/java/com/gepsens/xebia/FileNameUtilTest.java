package com.gepsens.xebia;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileNameUtilTest {

    @Test
    public void should_put_name_to_lower() throws Exception {
        assertEquals("objects", FileNameUtil.getDirNameForClass(Object.class));

    }
}
