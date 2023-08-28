import java.util.*;
import java.lang.*;

public class BronzeB_LostCow {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int farmerPos = input.nextInt();
        int cowPos = input.nextInt();

        int distanceTravelled = 0;
        int addedDistance = 0;

        int originalPosition = farmerPos;

        boolean positive = true;
        while(true) {
            if (positive) {
                distanceTravelled += Math.abs(farmerPos - originalPosition);
                farmerPos = originalPosition + (int) Math.pow(2, addedDistance++);
                distanceTravelled += (int) Math.pow(2, addedDistance - 1);

                if (cowPos > originalPosition && farmerPos >= cowPos) {
                    distanceTravelled -= Math.abs(farmerPos - cowPos);
                    break;
                }
                positive = false;
            }
            else if (!positive) {
                distanceTravelled += Math.abs(farmerPos - originalPosition);
                farmerPos = originalPosition - (int) Math.pow(2, addedDistance++);
                distanceTravelled += (int) Math.pow(2, addedDistance - 1);

                if (originalPosition > cowPos && farmerPos <= cowPos) {
                    distanceTravelled -= Math.abs(farmerPos - cowPos);
                    break;
                }
                positive = true;
            }
        }
        System.out.print(distanceTravelled);
    }
}


