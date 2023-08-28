import java.util.*;
import java.lang.*;

public class BronzeB_WheelRotation {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] array = new int[length];
        int holder;
        for (int i = 0; i < length - 1; i++) {
            holder = input.nextInt();
            holder = input.nextInt();
            array[i] = input.nextInt();
        }

        int direction = 0;
        for (int i = 0; i < length - 1; i++) {
            direction = direction ^ array[i];
        }

        System.out.print(direction);
    }
}
