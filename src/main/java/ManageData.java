import models.InfoPerson;
import java.sql.Connection;
import java.util.ArrayList;

public class ManageData {


    static ArrayList<InfoPerson> Datas = ReadExcel.getDatas();
    static ArrayList<InfoPerson> Addresses = ReadExcel.getAddress();

    public static void main(String[] args) {

    }

    public static void editTitle(){
        for (int i=0; i<Datas.size(); i++){

        }
    }

    public static void editAddress(){

    }

    public static void editMobile(){

    }

}
