import java.util.*;
import java.lang.*;

public class BronzeB_Hexconversion {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        String hex = input.next();

        // if 0:
        if (hex.equals("0")) {
            System.out.print(0);
            System.exit(0);
        }

        //make hex divisible by 3
        while (hex.length() % 3 != 0) {
            hex = "0" + hex;
        }

        int dec;
        String octString = "";
        ArrayList<String> array = new ArrayList<>();

        for (int i = 3; i <= hex.length(); i += 3) {
            dec = Integer.parseInt( hex.substring(i-3, i), 16);
            octString = Integer.toOctalString(dec);
            while (octString.length() < 4) {
                octString = "0" + octString;
            }
            array.add(octString);
        }

        String beginString = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (i == 0) {
                while(beginString.charAt(0) == '0') {
                    beginString = beginString.substring(1);
                }
                System.out.print(beginString);
            }
            else
                System.out.print(array.get(i));
        }
    }
}






