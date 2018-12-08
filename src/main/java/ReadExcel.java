import models.Address;
import models.InfoPerson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcel {

    private static ArrayList<InfoPerson> datas = new ArrayList<>();
    private static ArrayList<InfoPerson> newDatas = new ArrayList<>();
    private static ArrayList<Address> address = new ArrayList<>();

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
        writeInput();
//        address = readAddress(sheet2);
//        showData(datas);
//        showData(address);

        //create managedata
//        ManageData manageData = new ManageData(datas, address);
        ManageData manageData = new ManageData(datas);
        manageData.editTitle();
        manageData.editAddress();
        manageData.editMobile();

        writeOutput(manageData);

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
                    rowData = rowData + cell.toString() + ":";
                }
            }
            String[] splitRow = rowData.split(":");
            if (rowIndex > 0) {
                String title = splitRow[2];
                String name = splitRow[3];
                String surname = splitRow[4];
                String address = splitRow[5];
                String mobile = splitRow[6];
                array.add(new InfoPerson(title, name, surname, address, mobile));
            }
            rowIndex++;
        }
        return array;
    }

    public static void writeOutput(ManageData manageData) {
        try {

            File file2 = new File("output.txt");
            FileWriter fileWriter2 = new FileWriter(file2);
            System.out.println("writing output file.....");
            for (int j = 0; j < manageData.getData().size(); j++) {
                fileWriter2.write(String.valueOf(manageData.getData().get(j)) + "\n");
            }
            fileWriter2.write("\n ---------ข้อมูลที่แก้ไขไม่ได้หรือแก้ไขได้ยาก---------\n");
            for (int k = 0; k < manageData.getUselessData().size(); k++){
                fileWriter2.write(String.valueOf(manageData.getUselessData().get(k))+"\n");
            }
            fileWriter2.flush();
            fileWriter2.close();
            System.out.println("writing output file success.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInput() {
        try {
            File file1 = new File("input.txt");
            FileWriter fileWriter1 = new FileWriter(file1);
            System.out.println("writing input file.....");
            for (int i = 0; i < datas.size(); i++) {
                fileWriter1.write(String.valueOf(datas.get(i)) + "\n");
            }
            fileWriter1.flush();
            fileWriter1.close();
            System.out.println("writing input file success.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Address> readAddress(XSSFSheet sheet) {
        ArrayList<Address> array = new ArrayList<>();
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
                    rowData = rowData + cell.toString() + ":";
                }
            }
            String[] splitRow = rowData.split(":");
            if (rowIndex > 0) {
                String province = splitRow[0];
                String district = splitRow[1];
                String subdistrict = splitRow[2];
                String zipcode = splitRow[3];
                array.add(new Address(province, district, subdistrict, zipcode));
            }
            rowIndex++;
        }
        return array;
    }
}