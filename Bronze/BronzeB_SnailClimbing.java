import java.util.*;
import java.lang.*;

public class BronzeB_SnailClimbing {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int up = input.nextInt();
        int down = input.nextInt();
        int depth = input.nextInt();

        int difference = up - down;
        int quotient = depth/difference;
        int solution = quotient;

        if ( (up + (quotient - 2) * difference) >= depth) {
            solution = quotient - 1;
        }
        else if ((up + (quotient-1)*difference) >= depth) {
            solution = quotient;
        }
        else if ((up + quotient*difference) >= depth) {
            solution = quotient + 1;
        }
        System.out.print(solution);
    }
}
