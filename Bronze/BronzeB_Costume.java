import java.util.*;
import java.io.*;
import java.lang.Math;

public class BronzeB_Costume {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfCows = input.nextInt();
        int lengthOfCostume = input.nextInt();

        //put cows into array and sort array
        int[] cowLengths = new int[numberOfCows];
        for (int index = 0; index < cowLengths.length; index++) {
            cowLengths[index] = input.nextInt();
        }
        Arrays.sort(cowLengths);

        int totalSolutions = 0;
        int totalCowLengths;
        for (int firstCow = 0; firstCow < cowLengths.length; firstCow++) {
            for (int secondCow = firstCow + 1; secondCow < cowLengths.length; secondCow++) {
                totalCowLengths = cowLengths[firstCow] + cowLengths[secondCow];

                if (totalCowLengths <= lengthOfCostume) {
                    totalSolutions++;
                }
                else
                    break;
            }
        }

        System.out.println(totalSolutions);
    }
}
