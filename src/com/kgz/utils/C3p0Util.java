package com.kgz.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3p0Util {
    private static DataSource ds=new ComboPooledDataSource();

    public static DataSource getDs(){
        return ds;
    }
}
