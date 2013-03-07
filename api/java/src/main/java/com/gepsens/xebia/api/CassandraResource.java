package com.gepsens.xebia.api;

import com.gepsens.xebia.cass.AstyanaxPersistor;

public class CassandraResource {

    protected AstyanaxPersistor context;

    public CassandraResource(AstyanaxPersistor context) {
        this.context = context;
    }
}
