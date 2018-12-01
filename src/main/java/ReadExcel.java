import models.InfoPerson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ReadExcel {

    private static ArrayList<InfoPerson> datas = new ArrayList<>();
    private static ArrayList<InfoPerson> address = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File file = new File("utility.xlsx");
        FileInputStream fis = new FileInputStream(file);
        //we create an XSSF Workbook object for our XLSX Excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //we get first sheet
        XSSFSheet sheet1 = workbook.getSheetAt(0);
        XSSFSheet sheet2 = workbook.getSheetAt(1);

        //readExcel
        datas = readExcel(sheet1);
//        address = readExcel(sheet2);

//        showData(datas);

        workbook.close();
        fis.close();
    }

    public static ArrayList<InfoPerson> readExcel(XSSFSheet sheet) {
        ArrayList<InfoPerson> array = new ArrayList<>();
        //we iterate on rows
        Iterator<Row> rowIt = sheet.iterator();

        int rowIndex = 0;
        while (rowIt.hasNext()) {
            Row row = rowIt.next();
            //iterate on cells for the current row
            Iterator<Cell> cellIt = row.cellIterator();
            String rowData = "";
            while (cellIt.hasNext()) {
                Cell cell = cellIt.next(); // ช่องๆนึงของ excel
                if (rowIndex > 0) {
                    rowData = rowData + cell.toString() + ",";
                }
            }
            String[] splitRow = rowData.split(",");
            for (String d : splitRow){
                System.out.print(d+" ");
            }
            System.out.println(Arrays.toString(splitRow));

            rowIndex++;
        }
//        for (InfoPerson arr : datas) {
//            System.out.print(arr.getTitle() + " ");
//            System.out.print(arr.getName() + " ");
//            System.out.print(arr.getSurname() + " ");
//            System.out.print(arr.getAddress() + " ");
//            System.out.print(arr.getMobile() + " ");
//            System.out.println();
//        }
        return array;
    }

    public static void showData(ArrayList<InfoPerson> datas) {
        for (InfoPerson arr : datas) {
            System.out.print(arr.getTitle() + " ");
            System.out.print(arr.getName() + " ");
            System.out.print(arr.getSurname() + " ");
            System.out.print(arr.getAddress() + " ");
            System.out.print(arr.getMobile() + " ");
            System.out.println();
        }
    }


    public static ArrayList<InfoPerson> getDatas() {
        return datas;
    }

    public static ArrayList<InfoPerson> getAddress() {
        return address;
    }

}

