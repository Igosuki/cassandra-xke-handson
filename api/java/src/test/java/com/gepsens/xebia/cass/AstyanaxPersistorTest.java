package com.gepsens.xebia.cass;

import com.netflix.astyanax.Keyspace;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class AstyanaxPersistorTest {

    @Test
    public void ping_should_return_hosts() throws Exception {
        AstyanaxPersistor astyanaxPersistor = new AstyanaxPersistor("test", "localPool");
        assertNotNull(astyanaxPersistor.ping());
    }

    @Test
    public void keyspace_should_have_same_name() throws Exception {
        AstyanaxPersistor astyanaxPersistor = new AstyanaxPersistor("test", "localPool");
        Keyspace currentKeySpace = astyanaxPersistor.getCurrentKeySpace();
        assertNotNull(currentKeySpace);
        assertEquals(currentKeySpace.getKeyspaceName(), "test");
    }
}
