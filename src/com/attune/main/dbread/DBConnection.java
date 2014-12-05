package com.attune.main.dbread;

import java.sql.*;

/**
 * Created by Madhawa.Chandrasena on 12/5/2014.
 */
public class DBConnection {

    static final String userName = "SM-LocalSiteDBUser";
    static final String password = "st3v3m@dden!";
    static final String url = "jdbc:microsoft:sqlserver://localhost:1433" + ";databaseName=sm_content_local";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement("SELECT  V.SKU" +
                    " FROM [sm_content_local].[dbo].[PRODUCT] PRO WITH (NOLOCK)" +
                    " LEFT JOIN [sm_content_local].[dbo].[PRODUCT_VARIANT] V  WITH (NOLOCK)" +
                    " ON PRO.PRODUCT_ID =  V.PRODUCT_ID" +
                    " WHERE V.SKU IS NOT NULL AND LEN(V.SKU) > 10" +
                    " AND PRO.STYLE = ? AND V.SIZE_NAME = ? AND V.COLOR_NAME=?");
/*
            String[] result = new String[20];
            if (rs != null) {
                while (rs.next()) {
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result.length; j++) {
                            result[j] = rs.getString(i);
                            System.out.println(result[j]);
                        }
                    }
                }
            }*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}
