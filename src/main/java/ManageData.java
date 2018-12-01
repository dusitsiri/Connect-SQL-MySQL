import models.Address;
import models.InfoPerson;
import java.sql.Connection;
import java.util.ArrayList;

public class ManageData {

    private ArrayList<InfoPerson> data;
    private ArrayList<Address> address;

    public ManageData(ArrayList<InfoPerson> data, ArrayList<Address> address){
        this.data = data;
        this.address = address;
    }

    public void editTitle(){
        System.out.println(111111111);
        for (int i=0; i<data.size(); i++){
            System.out.println(data.get(i));
        }
    }

    public static void editAddress(){

    }

    public static void editMobile(){

    }
}
