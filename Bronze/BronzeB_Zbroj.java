import java.util.*;
import java.lang.*;

public class BronzeB_Zbroj {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        String num1 = input.next();
        String num2 = input.next();

        String temp;
        if (Integer.parseInt(num1) > Integer.parseInt(num2)) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String num1_5 = num1;
        String num1_6 = num1;
        String num2_5 = num2;
        String num2_6 = num2;

        num1_5 = num1_5.replaceAll("6", "5");
        num1_6 = num1_6.replaceAll("5","6");
        num2_5 = num2_5.replaceAll("6", "5");
        num2_6 = num2_6.replaceAll("5","6");

        System.out.print(Integer.parseInt(num2_5) + Integer.parseInt(num1_5) + " ");
        System.out.print(Integer.parseInt(num2_6) + Integer.parseInt(num1_6));
    }
}
