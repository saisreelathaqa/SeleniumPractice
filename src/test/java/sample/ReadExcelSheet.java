package sample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelSheet {
    public static void main(String[] args) throws IOException {

        FileInputStream fs = new FileInputStream("C://Users//91950//Documents//sampleExcelsheet.xlsx");
        XSSFWorkbook wbook = new XSSFWorkbook(fs);
        XSSFSheet wsheet = wbook.getSheet("ProductData");
        XSSFRow row= wsheet.getRow(0);
        //Cell cell= row.getCell(0);
        int col_num = -1;

        for(int i=0; i < row.getLastCellNum(); i++) {
            if (row.getCell(i).getStringCellValue().trim().equals("Name")) {
                col_num = i;


                row = wsheet.getRow(1);
                XSSFCell cell = row.getCell(col_num);

                String value = cell.getStringCellValue();
                System.out.println("Value of the Excel Cell is - " + value);
            }
        }

    }
}
