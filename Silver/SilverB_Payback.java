import java.util.*;

public class SilverB_Payback {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();

        int sum = 0;
        int distance = 0;
        boolean setMarker = false; int marker = 0;
        for (int i = 0; i < numCows; i++) {
            sum += input.nextInt();
            distance++;
            if (sum < 0 && !setMarker) {
                marker = i;
                setMarker = true;
            }
            else if (sum >= 0 && setMarker) {
                setMarker = false;
                distance += 2*(i - marker);
            }
        }

        System.out.print(distance);
    }
}

/**
 for (int i = 0; i < numCows; i++) {
 System.out.println(debt[i]);
 }

 for (int i = 0; i < numCows; i++) {
 System.out.println(totalDebt[i]);
 }
 */