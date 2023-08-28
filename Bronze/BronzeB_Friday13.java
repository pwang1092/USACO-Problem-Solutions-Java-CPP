import java.util.*;
import java.lang.*;

public class BronzeB_Friday13 {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[7];
        int day = -3;
        boolean leapyear = false;

        for (int i = 1900; i < 1900 + n; i++) {
            // determine if leap year
            if (i % 4 == 0 && i % 100 != 0) {
                leapyear = true;
            }
            else if (i % 400 == 0) {
                leapyear = true;
            }
            else {
                leapyear = false;
            }
            for (int j = 0; j < 12; j++) { // for the month
                if (j == 4 || j == 6 || j == 9 || j == 11) {
                    // follows 30 day month
                    day += 2;
                    array[(day) % 7]++;
                }
                else if (j == 0 || j == 1 || j == 3 || j == 5 || j == 7|| j == 8 || j == 10) {
                    // follows 31 day month
                    day += 3;
                    array[(day) % 7]++;
                }
                else if (j == 2){
                    if (leapyear) {
                        day += 1;
                        array[day%7]++;
                    }
                    else if (!leapyear){
                        array[day%7]++;
                        leapyear = false;
                    }
                }
            }
        }

        for (int a = 0; a < array.length; a++) {
            System.out.print(array[a] + " ");
        }
    }
}
