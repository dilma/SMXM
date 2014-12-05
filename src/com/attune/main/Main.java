package com.attune.main;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

	// write your code here
        CSVFileWriter csvFileWriter = new CSVFileWriter();
        List<Object> mihan = Arrays.asList(new Object[]{"Normal", "red", "small", "293"});
        System.out.println("csvFileWriter = " + csvFileWriter.getFileEmptyFlag());
        try {
            csvFileWriter.writeCSVFile(mihan,csvFileWriter.getFileEmptyFlag());

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Object> mihans = Arrays.asList(new Object[]{"XXL", "yellow", "big", "2933"});
        System.out.println("csvFileWriter = " + csvFileWriter.getFileEmptyFlag());
        try {
            csvFileWriter.writeCSVFile(mihans,csvFileWriter.getFileEmptyFlag());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
