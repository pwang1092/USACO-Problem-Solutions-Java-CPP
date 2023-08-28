import java.util.*;
import java.lang.*;

public class BronzeB_DecimalConversion {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int base = input.nextInt();
        String answer = "";
        int remainder;
        while (num > 0) {
            remainder = num % base;
            answer = remainder + answer;
            num /= base;
        }

        System.out.print(answer);
    }
}






