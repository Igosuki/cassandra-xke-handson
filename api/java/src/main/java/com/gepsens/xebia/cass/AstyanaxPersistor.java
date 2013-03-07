package com.gepsens.xebia.cass;

import java.io.IOException;
import java.util.Properties;
import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;

public class AstyanaxPersistor {

    private AstyanaxContext<Keyspace> context;

    private Keyspace currentKeySpace;

    private Properties cassandraConf;

    public AstyanaxPersistor(String keySpace, String pool) {
        loadConf();
        this.context = new AstyanaxContext.Builder()
                .forKeyspace(keySpace)
                .withAstyanaxConfiguration(new AstyanaxConfigurationImpl()
                    .setDiscoveryType(NodeDiscoveryType.RING_DESCRIBE)
                    .setCqlVersion("3.0.0")
                    .setTargetCassandraVersion("1.2")
                )
                .withConnectionPoolConfiguration(new ConnectionPoolConfigurationImpl(pool)
                        .setPort(Integer.valueOf(conf("port")))
                        .setMaxConnsPerHost(2)
                        .setSeeds(conf("seeds"))
                )
                .withConnectionPoolMonitor(new CountingConnectionPoolMonitor())
                .buildKeyspace(ThriftFamilyFactory.getInstance());
        this.context.start();
        this.currentKeySpace = this.context.getEntity();
    }

    public String ping() {
        String rawHostList = this.context.getNodeDiscovery().getRawHostList();
        System.out.println("Cassandra hosts : " + rawHostList);
        return rawHostList;
    }

    public Keyspace getCurrentKeySpace() {
        return this.currentKeySpace;
    }

    private void loadConf() {
        this.cassandraConf = new Properties();
        try {
            this.cassandraConf.load(this.getClass().getResourceAsStream("/cassandra.properties"));
        } catch (IOException e) {
            System.out.println("Failed to load cassandra conf");
        }
    }

    private String conf(String key) {
        return (String) this.cassandraConf.get(key);
    }

}
