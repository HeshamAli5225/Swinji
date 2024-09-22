package utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Read_Data {

    //read data from Excel file and return it in 2D Array
    public String [][] read_data(String sheetName) throws IOException, InvalidFormatException {

    File file=new File("src/main/java/resources/excel_users_data.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet= workbook.getSheet(sheetName);
        int number_of_rows=sheet.getPhysicalNumberOfRows()-2;
        int Number_of_columns=sheet.getRow(0).getLastCellNum();
        String [][] data=new String[number_of_rows][Number_of_columns];
        //Fill Excel data in array
        for(int i=0;i<number_of_rows;i++){
            for(int k=0;k<Number_of_columns;k++){
                data[i][k]=sheet.getRow(i+1).getCell(k).getStringCellValue();
            }
        }
        return data;
    }


}
