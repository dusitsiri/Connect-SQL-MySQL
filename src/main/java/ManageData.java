import models.Address;
import models.InfoPerson;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

public class ManageData {

    private ArrayList<InfoPerson> data;
    private ArrayList<Address> address;

    public ManageData(ArrayList<InfoPerson> data, ArrayList<Address> address) {
        this.data = data;
        this.address = address;
    }

//    public ArrayList<InfoPerson> editTitle(){
//        for (int i=0; i<data.size(); i++){
//            System.out.println(data.get(i));
//        }
//    }

//    public  ArrayList<InfoPerson> editAddress(){
//
//    }

    public ArrayList<InfoPerson> editMobile() {
        ArrayList<String> number = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getMobile().matches("[๐๑๒_๓๔๕๖๗๘๙-]+") ||
                    data.get(i).getMobile().matches("[012345678_9-]+")) {
                if (data.get(i).getMobile().contains("-")) {
                    number.add(changeTypeNumber(data.get(i).getMobile(), "-"));
                } else if (data.get(i).getMobile().contains("_")) {
                    number.add(changeTypeNumber(data.get(i).getMobile(), "_"));
                } else if (data.get(i).getMobile().substring(0, 2).equals("66")){
                    data.get(i).setMobile(data.get(i).getMobile().replace(
                            data.get(i).getMobile().substring(0, 2)+"", '0'+""));
                    number.add(data.get(i).getMobile());
                } else {
                    number.add(data.get(i).getMobile());
                }
            }

        }
        return this.data;
    }

    public String changeTypeNumber(String mobile, String split) {
        String[] splitMobile = new String[0];
        if (split.equals("-")) {
            splitMobile = mobile.split("-");
        } else if (split.equals("_")){
            splitMobile = mobile.split("_");
        }
        String temp = "";
        for (String list : splitMobile) {
            temp += list;
        }
        if (!temp.matches("[0-9]+")){
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '๐') temp = temp.replace(temp.charAt(i), '0');
                else if (temp.charAt(i) == '๑') temp = temp.replace(temp.charAt(i), '1');
                else if (temp.charAt(i) == '๒') temp = temp.replace(temp.charAt(i), '2');
                else if (temp.charAt(i) == '๓') temp = temp.replace(temp.charAt(i), '3');
                else if (temp.charAt(i) == '๔') temp = temp.replace(temp.charAt(i), '4');
                else if (temp.charAt(i) == '๕') temp = temp.replace(temp.charAt(i), '5');
                else if (temp.charAt(i) == '๖') temp = temp.replace(temp.charAt(i), '6');
                else if (temp.charAt(i) == '๗') temp = temp.replace(temp.charAt(i), '7');
                else if (temp.charAt(i) == '๘') temp = temp.replace(temp.charAt(i), '8');
                else if (temp.charAt(i) == '๙') temp = temp.replace(temp.charAt(i), '9');
            }
        }
        return temp;
    }
}
