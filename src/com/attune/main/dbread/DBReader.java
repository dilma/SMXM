package com.attune.main.dbread;

import com.attune.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madhawa.Chandrasena on 12/5/2014.
 */
public class DBReader {

    public List<Product> getProductsSKU(List<Product> products) {

        try {
            Connection con = DBConnection.getConnection();
            for (Product p : products) {
                PreparedStatement ps = con.prepareStatement("SELECT  V.SKU FROM [sm_content_local].[dbo].[PRODUCT] PRO WITH (NOLOCK) LEFT JOIN [sm_content_local].[dbo].[PRODUCT_VARIANT] V  WITH (NOLOCK) ON PRO.PRODUCT_ID =  V.PRODUCT_ID WHERE V.SKU IS NOT NULL AND LEN(V.SKU) > 10 AND PRO.STYLE = ? AND V.SIZE_NAME = ? AND V.COLOR_NAME=?");
                ps.setString(1, p.getStyle());
                ps.setString(2, p.getSize());
                ps.setString(3, p.getColor());

                ResultSet rs = ps.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        String s = rs.getString(1);
                        p.setUpc(s);
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
