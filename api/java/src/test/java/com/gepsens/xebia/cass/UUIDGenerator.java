package com.gepsens.xebia.cass;

import com.netflix.astyanax.util.TimeUUIDUtils;
import org.junit.Test;


public class UUIDGenerator {

    @Test
    public void generateUUIDS() throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            System.out.println(TimeUUIDUtils.getTimeUUID(System.nanoTime()));
            Thread.sleep(20);
        }

    }
}
