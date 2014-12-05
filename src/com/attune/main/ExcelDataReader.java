package com.attune.main;

import com.attune.model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Chandima.Rajaguru on 12/5/2014.
 */
public class ExcelDataReader {

    public List<Product> readProductData(){
        List<Product> productList = new ArrayList<Product>();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("resources/input/Products_Extract.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet worksheet = workbook.getSheet("Sheet1");

            Iterator<Row> rowIterator = worksheet.iterator();
            Long count = 0L;
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if(count != 0L ){
                    Product product = new Product();
                    Cell cell1 = row.getCell(0);
                    if(cell1 != null){
                        product.setStyle(cell1.getStringCellValue());
                    }
                    Cell cell2 = row.getCell(1);
                    if(cell2 != null){
                        product.setColor(cell2.getStringCellValue());
                    }
                    Cell cell3 = row.getCell(2);
                    if(cell3 != null){
                        product.setSize(cell3.getStringCellValue());
                    }
                    productList.add(product);
                }
                count++;
            }
            fileInputStream.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(fileInputStream);
        }

        return productList;
    }

}
