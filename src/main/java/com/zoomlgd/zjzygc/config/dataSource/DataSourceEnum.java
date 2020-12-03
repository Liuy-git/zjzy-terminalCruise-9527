package com.zoomlgd.zjzygc.config.dataSource;

/**
 * @author ldw
 */

public enum DataSourceEnum {
    ZJZYWX("zjzywx"),
    MYSQL("mysql");
    private String value;
    DataSourceEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
