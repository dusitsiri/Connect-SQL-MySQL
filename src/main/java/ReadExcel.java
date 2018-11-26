import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sqlite_databases.SqliteConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;

public class ReadExcel {

    //Connect to Sqlite
    static SqliteConnection sqliteConnection = new SqliteConnection();
    Connection connection = sqliteConnection.connect();

    public static void main(String[] args) throws IOException {
        File excelFile = new File("IQM.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        //we create an XSSF Workbook object for our XLSX Excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        //we iterate on rows
        Iterator<Row> rowIt = sheet.iterator();

        int rowIndex = 0;
        while(rowIt.hasNext()){
            Row row = rowIt.next();
            //iterate on cells for the current row
            Iterator<Cell> cellIt = row.cellIterator();
            String rowData = "";
            while(cellIt.hasNext()){
                Cell cell = cellIt.next(); // ช่องๆนึงของ excel
                if (rowIndex > 0) {
                    rowData = rowData + cell.toString()+ ":";
                }
            }
//            if (rowIndex > 0){
//                String[] line = rowData.split(":");
//                System.out.println(line[0] + line[2]+line[3]+line[4]+line[5]+line[6]);
//                sqliteConnection.insert(line[0], line[2], line[3], line[4], line[5], line[6]);
//                System.out.println(rowIndex);
//            }
//            System.out.println();
//            rowIndex++;
        }

        workbook.close();
        fis.close();
    }
}
