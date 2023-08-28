import java.util.*;
import java.lang.*;

public class BronzeB_Conversion {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int numCopy = num;
        int base = input.nextInt();
        int numLength = 0;
        while (true) {
            if (numCopy == 0) {
                break;
            }
            numCopy/= 10;
            numLength++;
        }

        /** multiply each digit by the appropriate place value with proper power */
        int solution = 0;
        for (int i = 0; i < numLength; i++) {
            solution += (num % 10) * (int) Math.pow(base, i);
            num /= 10;
        }
        System.out.print(solution);
    }
}






