import java.util.Scanner;
import java.util.*;

public class Bronze_NumberGame {

    public static String max = "0";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String[] array = new String[num];

        for (int i = 0; i < num; i++) {
            array[i] = "" + input.nextInt();
        }

        int[] used = new int[10];

        dfs(array, used, array[0],0);
        dfs(array, used,"",0);

        if (max.equals("0")) {
            System.out.println("IMPOSSIBLE");
        }
        else
            System.out.print(max);
    }

    public static void dfs(String array[], int[] used, String number, int index) {

        if (number.length() > 9) {
            return;
        }
        if (number.length() == 9) {
            if (Integer.parseInt(number) > Integer.parseInt(max)) {
                max = number;
            }
        }
        if (index + 1 == array.length) {
            return;
        }

        if (used[array[index].length()] == 0) {
            used[array[index].length()] = 1;

            dfs(array, used, number + array[index + 1], index+1);
            dfs(array, used, array[index + 1] + number, index+1);

            used[array[index].length()] = 0;
        }

        dfs(array, used, number, index+1);
    }
}
