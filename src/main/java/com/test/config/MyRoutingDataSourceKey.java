package com.test.config;

import java.util.HashMap;
import java.util.Map;

public enum MyRoutingDataSourceKey {

    DATASOURCE_KEY1("ds1"),
    DATASOURCE_KEY2("ds2"),
    DATASOURCE_UNKNOWN("unknown");

    private String name;

    MyRoutingDataSourceKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final Map<String, MyRoutingDataSourceKey> map = new HashMap<>();

    static {
        for (MyRoutingDataSourceKey dataSourceKey : MyRoutingDataSourceKey.values()) {
            map.put(dataSourceKey.getName(), dataSourceKey);
        }
    }

    public static MyRoutingDataSourceKey getByName(String name) {
        return map.get(name);
    }

}
