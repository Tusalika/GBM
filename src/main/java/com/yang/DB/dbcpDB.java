package com.yang.DB;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Adminitster on 2016/11/13.
 */
public class dbcpDB {
    private static DataSource ds=null;
    private static Connection conn=null;
    static{

        Properties pro=new Properties();
        try {

            pro.load(dbcpDB.class.getClassLoader().getResourceAsStream("dbcp.ini"));
            ds= BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.print(dbcpDB.getDBCPConnection());
    }
    public static Connection getDBCPConnection(){
        try {
            conn= ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}