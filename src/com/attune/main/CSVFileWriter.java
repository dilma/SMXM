package com.attune.main;

import com.attune.model.Product;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.util.List;

/**
 * Created by Mihan.Liyanage on 12/5/2014.
 */
public class CSVFileWriter{

    private final static String[] header = new String[] { "STYLE","COLOR","SIZE","UPC"};
    private final static String filePath = "resources/output/result.csv";

    /**
     * Write content of the product object to csv file
     * @throws Exception Files related exceptions
     */
    public static void writeCSVFile(List<Product> content) throws Exception {

        ICsvListWriter listWriter = null;

        try {
            listWriter = new CsvListWriter(new FileWriter(filePath), CsvPreference.STANDARD_PREFERENCE);

            //write the product header
            listWriter.writeHeader(header);

            //write the product lists
            for(Product p:content){
                listWriter.write(p.getStyle(),p.getColor(),p.getSize(),p.getUpc());
            }

        }finally {
            if( listWriter != null ) {
                listWriter.close();
            }
        }
    }
}