package com.attune.main;

import com.attune.main.dbread.DBReader;
import com.attune.model.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            ExcelDataReader reader = new ExcelDataReader();
            List<Product> list = reader.readProductData();
            CSVFileWriter fileWriter = new CSVFileWriter();
            DBReader dbReader = new DBReader();
            boolean flag = fileWriter.getFileEmptyFlag();
            fileWriter.writeCSVFile(dbReader.getProductsSKU(list), flag);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
