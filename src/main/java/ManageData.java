import models.Address;
import models.InfoPerson;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ManageData {

    private ArrayList<InfoPerson> data;
    private ArrayList<Address> address;

    public ManageData(ArrayList<InfoPerson> data, ArrayList<Address> address) {
        this.data = data;
        this.address = address;
    }

    public void editTitle() {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getTitle().matches("[mM][rR].?|นาย.?")) {
                data.get(i).setTitle("นาย");
            } else if (data.get(i).getTitle().matches("[mM][rR][sS].?|นาง.?")) {
                data.get(i).setTitle("นาง");
            } else if (data.get(i).getTitle().matches("[mM][sS].?|น.?ส.?")) {
                data.get(i).setTitle("นางสาว");
            } else if (!data.get(i).getTitle().substring(2, 3).matches("ย|ง")) {
                Random random = new Random();
                char replaceChar = "ยง".charAt(random.nextInt("ยง".length()-1));
                if (replaceChar == 'ย') data.get(i).setTitle("นาย");
                else data.get(i).setTitle("นาง");
            }
        }
    }

    public void editAddress() {

    }

    public void editMobile() {
        for (int i = 0; i < data.size(); i++) {
            //Thai and numeric number with underscroll(_) or hyphen(-)
            if (data.get(i).getMobile().matches("[๐๑๒๓๔๕๖๗๘๙_-]+") ||
                    data.get(i).getMobile().matches("[0123456789_-]+")) {

                if (data.get(i).getMobile().contains("-")) {
                    data.get(i).setMobile(changeTypeNumber(data.get(i).getMobile(), "-"));
                } else if (data.get(i).getMobile().contains("_")) {
                    data.get(i).setMobile(changeTypeNumber(data.get(i).getMobile(), "_"));
                } else if (!data.get(i).getMobile().substring(0, 2).matches("[0][123456789]")) {
                    data.get(i).setMobile(data.get(i).getMobile().replace(
                            data.get(i).getMobile().substring(0, 2) + "", '0' + ""));
                    data.get(i).setMobile(data.get(i).getMobile());
                }
                //numeric number [0-9]+
                else {
                    data.get(i).setMobile(data.get(i).getMobile());
                }
            }

        }
    }

    public String changeTypeNumber(String mobile, String splitChar) {
        //split special char in mobile number to string array
        String[] splitMobile = mobile.split(splitChar);

        //append number without special char
        String temp = "";
        for (String list : splitMobile) {
            temp += list;
        }

        //Thai number replace by numeric number
        if (!temp.matches("[0-9]+")) {
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

    //get Personal Information
    public ArrayList<InfoPerson> getData() {
        return data;
    }
}
