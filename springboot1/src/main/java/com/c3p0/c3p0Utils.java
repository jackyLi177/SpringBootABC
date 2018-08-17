package com.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author : liyongjie
 * @Date : 2018/7/4 0004
 */
public class c3p0Utils {

    public static DataSource getDataSource(){
        //C3P0PooledDataSource c3P0PooledDataSource = new C3P0PooledDataSource();
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("root");
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&rewriteBatchedStatements=true&useCursorFetch=true&defaultFetchSize=10000");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }

    public static Connection getConn() throws SQLException {
        return getDataSource().getConnection();
    }

}
