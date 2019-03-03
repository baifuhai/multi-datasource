package com.test.config;

public class MyRoutingDataSourceHolder {

    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<>();

    public static String getDataSourceKey() {
        return dataSourceKey.get();
    }

    public static String getDataSourceKey1() {
        return MyRoutingDataSourceKey.DATASOURCE_KEY1.getName();
    }

    public static String getDataSourceKey2() {
        return MyRoutingDataSourceKey.DATASOURCE_KEY2.getName();
    }

    public static void setDataSourceKey(String key) {
        dataSourceKey.set(key);
    }

    public static void setDataSourceKey1() {
        dataSourceKey.set(MyRoutingDataSourceKey.DATASOURCE_KEY1.getName());
    }

    public static void setDataSourceKey2() {
        dataSourceKey.set(MyRoutingDataSourceKey.DATASOURCE_KEY2.getName());
    }

    public static void resetDataSourceKey() {
        setDataSourceKey1();
    }

}
