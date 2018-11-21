import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcel {
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
            while(cellIt.hasNext()){
                Cell cell = cellIt.next();
                if (rowIndex == 0) {
                    System.out.print(cell.toString() + ":");
                }
            }
//            System.out.println();
            rowIndex++;
        }

        workbook.close();
        fis.close();
    }
}
