package com.attune.main;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mihan.Liyanage on 12/5/2014.
 */
public class CSVFileWriter{

    final static String[] header = new String[] { "STYLE","COLOR","SIZE","UPC"};
    final static String filePath = "C:\\Users\\Mihan.Liyanage\\Desktop\\target\\result.csv";

    /**
     * File data types with constraints
     * @return constraint list
     */
    private static CellProcessor[] getProcessors() {

        final CellProcessor[] processors = new CellProcessor[] {
            new NotNull(), //STYLE
            new NotNull(), //COLOR
            new NotNull(), //SIZE
            new UniqueHashCode() //UPC
        };

        return processors;
    }

    public boolean getFileEmptyFlag() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        if (bufferedReader.readLine() == null) {
            return true;
        }

        return false;
    }

    /**
     * Write content of the product object to csv file
     * @throws Exception Files related exceptions
     */
    public static void writeCSVFile(List<Object> content, boolean flag) throws Exception {

        ICsvListWriter listWriter = null;

        try {
            listWriter = new CsvListWriter(new FileWriter(filePath, true), CsvPreference.STANDARD_PREFERENCE);

            final CellProcessor[] processors = getProcessors();

            if(flag){
                listWriter.writeHeader(header);
            }

            // write the customer lists
            listWriter.write(content, processors);

        }finally {
            if( listWriter != null ) {
                listWriter.close();
            }
        }
    }
}