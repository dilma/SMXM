package com.attune.main.dbread;

import java.sql.*;

/**
 * Created by Madhawa.Chandrasena on 12/5/2014.
 */
public class DBConnection {

    static final String userName = "SM-LocalSiteDBUser";
    static final String password = "st3v3m@dden!";
    static final String url = "jdbc:sqlserver://localhost:1433" + ";databaseName=sm_content_local";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            return con;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


}
