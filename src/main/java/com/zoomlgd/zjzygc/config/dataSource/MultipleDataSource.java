package com.zoomlgd.zjzygc.config.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author ldw
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
