import java.util.*;
import java.lang.*;

public class BronzeB_Breakout {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numDays = input.nextInt();
        int[] array = new int[numDays];
        for (int i = 0; i < numDays; i++) {
            array[i] = input.nextInt();
        }
        array[0] = 0;

        int countdown;
        boolean contradiction = false;
        for (int i = 0; i < numDays; i++) {
            if (array[i] > 0) {
                countdown = array[i];
                for (int j = 1; j <= array[i]; j++) {
                    if (array[i - j] > 0 && array[i - j] != countdown - j) {
                        contradiction = true;
                    }
                    array[i - j] = countdown - j;
                }
            }
        }
        if (contradiction) {
            System.out.print(-1);
            System.exit(0);
        }

        int error = 0;
        int solution = 0;
        for (int i = 0; i < numDays; i++) {
            if (array[i] == 0) {
                solution++;
            }
            else if (array[i] < 0) {
                error++;
            }
        }

        System.out.print(solution + " " + (solution + error));
    }
}


