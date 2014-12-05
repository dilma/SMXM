package com.attune.main;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Chandima.Rajaguru\\Desktop\\poi-test.xls");
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            Sheet worksheet = workbook.getSheet("POI Worksheet");
            Row row1 = worksheet.getRow(0);
            Cell cellA1 = row1.getCell(0);
            String a1Val = cellA1.getStringCellValue();
            Cell cellB1 = row1.getCell(1);
            String b1Val = cellB1.getStringCellValue();
            Cell cellC1 = row1.getCell(2);
            String c1Val = cellB1.getStringCellValue();
            Cell cellD1 = row1.getCell(3);
            String d1Val = cellB1.getStringCellValue();

            System.out.println("A1: " + a1Val);
            System.out.println("B1: " + b1Val);
            System.out.println("C1: " + c1Val);
            System.out.println("D1: " + d1Val);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
