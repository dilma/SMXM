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
                    Cell cellStyle = row.getCell(0);
                    if(cellStyle != null){
                        product.setStyle(cellStyle.getStringCellValue());
                    }
                    Cell cellColor = row.getCell(1);
                    if(cellColor != null){
                        product.setColor(cellColor.getStringCellValue());
                    }
                    Cell cellSize = row.getCell(2);
                    if(cellSize != null){
                        product.setSize(cellSize.getStringCellValue());
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
