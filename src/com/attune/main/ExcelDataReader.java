package com.attune.main;

import com.attune.model.Product;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chandima.Rajaguru on 12/5/2014.
 */
public class ExcelDataReader {

    public List<Product> readData(){
        List<Product> productList = new ArrayList<Product>();
        try {
            FileInputStream fileInputStream = new FileInputStream("resources/input/Products_Extract.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet worksheet = workbook.getSheet("Sheet1");


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
