import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        String str = "ขว.ลาดยาว";
        if (str.matches("ขว.?(.*)?")){
            System.out.println(true);
        }
    }
}
