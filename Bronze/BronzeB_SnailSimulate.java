import java.util.*;
import java.lang.*;

public class BronzeB_SnailSimulate {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int up = input.nextInt();
        int down = input.nextInt();
        int depth = input.nextInt();

        int sum = 0;
        int days = 0;
        while(sum < depth) {
            days++;
            sum += up;
            if (sum >= depth) {
                break;
            }
            sum -= down;
        }

        System.out.print(days);
    }
}
