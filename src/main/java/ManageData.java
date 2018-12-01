import models.InfoPerson;
import java.sql.Connection;
import java.util.ArrayList;

public class ManageData {


    static ArrayList<InfoPerson> information = ReadExcel.getDatas();
    static ArrayList<InfoPerson> newInfo = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(information.size());
        for (InfoPerson infoPerson: information){
            System.out.println(infoPerson.getTitle());
            System.out.println(infoPerson.getName());
            System.out.println(infoPerson.getSurname());
            System.out.println(infoPerson.getAddress());
            System.out.println(infoPerson.getMobile());
        }

//        editInfoTitle();
//        editInfoMobile();
//        editInfoAddress();

//        for (int i = 0; i<information.size();i++){
//            System.out.println(information.get(i).getAddress());
//        }
//        System.out.println("---------------------------------------");
//        for (int i = 0; i<information.size();i++){
//            System.out.println(newInfo.get(i).getAddress());
//        }

//        for (int i = 0; i<information.size();i++){
//            System.out.println(newInfo.get(i).getTitle() +" "+ newInfo.get(i).getMobile());
//        }

        for (int i = 0; i<newInfo.size();i++){
            System.out.println(newInfo.get(i).toString());
        }
    }

//    public static void editInfoTitle(){
//        for (int i = 0; i<information.size();i++){
//            if (information.get(i).getTitle().contains("r") || information.get(i).getTitle().contains("R") || information.get(i).getTitle().contains("นาย")){
//                newInfo.get(i).setTitle("นาย");
//            }
//            else if (information.get(i).getTitle().contains("rs") || information.get(i).getTitle().contains("RS") || information.get(i).getTitle().equals("นาง")){
//                newInfo.get(i).setTitle("นาง");
//            }
//            else if (information.get(i).getTitle().contains("s") || information.get(i).getTitle().contains("S") || information.get(i).getTitle().contains("ส")
//            || (information.get(i).getTitle().contains("นางสาว"))){
//                newInfo.get(i).setTitle("นางสาว");
//            }
//            else{
//                newInfo.get(i).setTitle("นาย");
//            }
//        }
//    }
//
//    public static void editInfoMobile(){
//        for (int i = 0; i<information.size(); i++){
//            String temp = "";
//
//            for (int j=0; j<information.get(i).getMobile().length(); j++){ // วนลูปเบอร์โทรแต่ละหลัก
//                if (information.get(i).getMobile().charAt(j) == '0' || information.get(i).getMobile().charAt(j) == '๐'){
//                    temp += "0";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '1' || information.get(i).getMobile().charAt(j) == '๑'){
//                    temp += "1";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '2' || information.get(i).getMobile().charAt(j) == '๒'){
//                    temp += "2";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '3' || information.get(i).getMobile().charAt(j) == '๓'){
//                    temp += "3";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '4' || information.get(i).getMobile().charAt(j) == '๔'){
//                    temp += "4";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '5' || information.get(i).getMobile().charAt(j) == '๕'){
//                    temp += "5";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '6' || information.get(i).getMobile().charAt(j) == '๖'){
//                    temp += "6";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '7' || information.get(i).getMobile().charAt(j) == '๗'){
//                    temp += "7";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '8' || information.get(i).getMobile().charAt(j) == '๘'){
//                    temp += "8";
//                }
//                else if (information.get(i).getMobile().charAt(j) == '9' || information.get(i).getMobile().charAt(j) == '๙'){
//                    temp += "9";
//                }
//            }
//            newInfo.get(i).setMobile(temp);
//        }
//
//        for (int i = 0; i<newInfo.size(); i++){
//            if (newInfo.get(i).getMobile().length() != 10 && (newInfo.get(i).getMobile().charAt(0) == '6' || newInfo.get(i).getMobile().charAt(0) == '๖') &&
//                    (newInfo.get(i).getMobile().charAt(1) == '6' || newInfo.get(i).getMobile().charAt(1) == '๖')){ // แก้เลขที่ใส่ 66 สองตัวแรก
//                String temp = "08";
//
//                for (int j=2; j<newInfo.get(i).getMobile().length(); j++) {
//                    if (j < 11) {
//                        temp += newInfo.get(i).getMobile().charAt(j);
//                    }
//                }
//                newInfo.get(i).setMobile(temp);
//            }
//            if (newInfo.get(i).getMobile().length() != 10){ // แก้หลักที่เกิน 10 ตัว
//                String temp = "";
//                for (int j=0; j<newInfo.get(i).getMobile().length(); j++) {
//                    if (j < 10){
//                        temp += newInfo.get(i).getMobile().charAt(j);
//                    }
//                }
//                newInfo.get(i).setMobile(temp);
//            }
//        }
//    }
//
//    public static void editInfoAddress(){
//        for (int i = 0; i<information.size() ;i++){
//            String[] line = information.get(i).getAddress().split(" ");
//            String temp = "";
//            for (int j = 0; j<line.length ; j++){
//                 temp += changeWord(line[j]+" ");
//            }
//            newInfo.get(i).setAddress(temp);
//        }
//
//        for (int i = 0; i<newInfo.size() ;i++){
//            String[] line = newInfo.get(i).getAddress().split(" ");
//            String temp = "";
//            boolean checkNumFive = false;
//
//            for (int j = 0; j<line.length ; j++){
//
//                if ((line[j].equals("ม.") || line[j].contains("หมู่") || line[j].equals("ม")) && (line[j].length() == 2 || line[j].length() == 4)){
//                    temp += "ม.";
//                }
//                else if ((line[j].contains("ถ.") || line[j].contains("ถนน")) && (line[j].length() == 2 || line[j].length() == 3)){
//                    temp += "ถ.";
//                }
//                else if ((line[j].contains("ซ.") || line[j].contains("ซอย")) && (line[j].length() == 2 || line[j].length() == 3)){
//                    temp += "ซ.";
//                }
//                else if ((line[j].contains("ต.") || line[j].contains("แขวง") || line[j].contains("ตำบล")) && (line[j].length() == 2 || line[j].length() == 4)){
//                    temp += "ต.";
//                }
//                else if ((line[j].contains("อ.") || line[j].contains("เขต") || line[j].contains("อำเภอ")) && (line[j].length() == 2 || line[j].length() == 3 || line[j].length() == 5)){
//                    temp += "อ.";
//                }
//                else if ((line[j].contains("จ.") || line[j].contains("จังหวัด")) && (line[j].length() == 2 || line[j].length() == 7)){
//                    temp += "จ.";
//                }
//                else if (line[j].length() == 5 && line[j].contains("0")){
//                    temp += line[j] + " ";
//                    checkNumFive = true;
//                }
//                else if (!checkNumFive){ // พอหลังรหัสไปรษณีย์จะไม่มีการบันทึกค่าแล้ว
//                    temp += line[j] + " ";
//                }
//            }
//            newInfo.get(i).setAddress(temp);
//        }
//
////        for (int i = 0; i<newInfo.size() ;i++){
////            String[] line = newInfo.get(i).getAddress().split(" ");
////            String temp = "";
//
////            for (int j = 0; j<line.length ; j++){
////
////                if (line[j].contains("หมู่")){
////                    temp += "";
////                }
////                else if (line[j].contains("ถนน")){
////                    temp += "ถ.";
////                }
////                else if (line[j].contains("ซอย")){
////                    temp += "ซ.";
////                }
////                else if (line[j].contains("แขวง")){
////                    temp += "ต.";
////                }
////                else if ((line[j].contains("เขต") || line[j].contains("อำเภอ"))){
////                    temp += "อ.";
////                }
////                else if (line[j].contains("จังหวัด")){
////                    temp += "จ.";
////                }
////            }
////            newInfo.get(i).setAddress(temp);
////        }
//    }
//
//    public static String changeWord(String word){
//        String temp = "";
//        for (int i=0; i<word.length(); i++){
//            if (word.charAt(i) == '0' || word.charAt(i) == '๐'){
//                temp += "0";
//            }
//            else if (word.charAt(i) == '1' || word.charAt(i) == '๑'){
//                temp += "1";
//            }
//            else if (word.charAt(i) == '2' || word.charAt(i) == '๒'){
//                temp += "2";
//            }
//            else if (word.charAt(i) == '3' || word.charAt(i) == '๓'){
//                temp += "3";
//            }
//            else if (word.charAt(i) == '4' || word.charAt(i) == '๔'){
//                temp += "4";
//            }
//            else if (word.charAt(i) == '5' || word.charAt(i) == '๕'){
//                temp += "5";
//            }
//            else if (word.charAt(i) == '6' || word.charAt(i) == '๖'){
//                temp += "6";
//            }
//            else if (word.charAt(i) == '7' || word.charAt(i) == '๗'){
//                temp += "7";
//            }
//            else if (word.charAt(i) == '8' || word.charAt(i) == '๘'){
//                temp += "8";
//            }
//            else if (word.charAt(i) == '9' || word.charAt(i) == '๙'){
//                temp += "9";
//            }
//            else if (word.charAt(i) == '/' || word.charAt(i) == '\\'){
//                temp += "/";
//            }
//            else{
//                temp += word.charAt(i);
//            }
//        }
//        return temp;
//    }
}
