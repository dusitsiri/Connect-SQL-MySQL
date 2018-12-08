import models.Address;
import models.InfoPerson;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ManageData {

    private ArrayList<InfoPerson> data;
    private ArrayList<Address> address;
    private ArrayList<InfoPerson> uselessData = new ArrayList<>();

    public ManageData(ArrayList<InfoPerson> data) {
        this.data = data;
    }

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
                //random char in string given
                char replaceChar = "ยง".charAt(random.nextInt("ยง".length() - 1));
                if (replaceChar == 'ย') data.get(i).setTitle("นาย");
                else data.get(i).setTitle("นาง");
            }
        }
    }

    public void editAddress() {
        for (int i = 0; i < data.size(); i++) {
            String eachAddress = "";
            String[] str = data.get(i).getAddress().split(" ");
            if (str.length <= 1) {
                uselessData.add(data.get(i));
            } else {
                for (int j = 0; j < str.length; j++) {
                    //บ้านเลขที่
                    if (str[j].matches("[๐๑๒๓๔๕๖๗๘๙]*/?[๐๑๒๓๔๕๖๗๘๙]*")) {
                        str[j] = thaiNumToArabic(str[j]);
                    }
                    if (str[j].matches("[0-9]*/?[0-9]*") && j == 0) {
                        if (str[j + 1].matches("[0-9]+|[๐๑๒๓๔๕๖๗๘๙]+")) {
                            str[j] += str[j + 1];
                            str[j + 1] = "";
                        }
                        eachAddress += str[j].trim() + " ";
                    }
                    //หมู่ ซอย ถนน ตำบล อำเภอ จังหวัด รหัสไปรษณีย์
                    else if (str[j].matches("[ั์ะาิีึืุูเแ่้๊๋็โำใไฤๅฯ./a-zA-Zก-ฮ0-9-]+")) {
                        if (!str[j].matches("[0-9]*") && j == str.length - 1 && str[j - 1].matches("[0-9]*")) {
                            String temp = str[j - 1];
                            str[j - 1] = str[j];
                            str[j] = temp;
                        } else if (str[j].matches("ห?ม[ู่.]?(.*)?")) {
                            if (str[j].contains("ม.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "หมู่");
                            } else if (str[j].matches("ม")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("ม") + 1), "หมู่");
                            }
                        } else if (str[j].matches("ซ[อย.]*?(.*)?")) {
                            if (str[j].contains("ซ.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "ซอย");
                            } else if (str[j].matches("ซ")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("ซ") + 1), "ซอย");
                            }
                        } else if (str[j].matches("ถ[น.]*?(.*)?")) {
                            if (str[j].contains("ถ.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "ถนน");
                            } else if (str[j].matches("ถ")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("ถ") + 1), "ถนน");
                            }
                        } else if (str[j].matches("ต[ำบล.]*?(.*)?")) {
                            if (str[j].contains("ต.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "ตำบล");
                            } else if (str[j].matches("ต")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("ต") + 1), "ตำบล");
                            }
                        } else if (str[j].matches("อ[ำเภอ.]*?(.*)?")) {
                            if (str[j].contains("อ.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "อำเภอ");
                            } else if (str[j].matches("อ")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("อ") + 1), "อำเภอ");
                            }
                        } else if (str[j].matches("แ?ขว[ง.]*?(.*)?|ขว.?(.*)*?")) {
                            if (str[j].contains("ขว.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "แขวง");
                            } else if (str[j].matches("ขว")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("ว") + 1), "แขวง");
                            }
                        } else if (str[j].matches("เ?ข[ต.]*?(.*)?")) {
                            if (str[j].contains("ข.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "เขต");
                            } else if (str[j].matches("ข")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("ข") + 1), "เขต");
                            }
                        } else if (str[j].matches("จ[งหวัด.]*?(.*)?")) {
                            if (str[j].contains("จ.")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf(".") + 1), "จังหวัด");
                            } else if (str[j].matches("จ")) {
                                str[j] = str[j].replace(str[j].substring(0, str[j].indexOf("จ") + 1), "จังหวัด");
                            }
                        } else if (str[j].matches("(.*)?กทม[ฯ.]?|กรุงเทพมหานคร")) {
                            if (str[j].matches("กทมฯ")) {
                                str[j] = str[j].replace(str[j].substring(str[j].indexOf("ก"), str[j].indexOf("ฯ") + 1), "กรุงเทพฯ");
                            } else if (str[j].matches("กทม.")) {
                                str[j] = str[j].replace(str[j].substring(str[j].indexOf("ก"), str[j].indexOf(".") + 1), "กรุงเทพฯ");
                            } else if (str[j].matches("กทม")) {
                                str[j] = str[j].replace(str[j].substring(str[j].indexOf("ก"), str[j].indexOf("ม") + 1), "กรุงเทพฯ");
                            } else if (str[j].matches("กรุงเทพ")) {
                                str[j] = str[j].replace(str[j].substring(str[j].indexOf("ก"), str[j].indexOf("พ") + 1), "กรุงเทพฯ");
                            }
                        }
                        if (str[j].matches("[0-9]*") && str[j].length() == 5) {
                            eachAddress += str[j].trim();
                            break;
                        } else {
                            eachAddress += str[j].trim() + " ";
                        }
                    }
                }
                data.get(i).setAddress(eachAddress);
            }
        }
    }

    //edit mobile number and call changeTypeNumber method too
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
            temp = thaiNumToArabic(temp);
        }
        return temp;
    }

    public String thaiNumToArabic(String temp) {
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
        return temp;
    }

    //get Personal Information
    public ArrayList<InfoPerson> getData() {
        return data;
    }

    public ArrayList<InfoPerson> getUselessData() {
        return uselessData;
    }
}
