import java.util.*;

public class SilverB_Marathon2 {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        int numCheckpoint = input.nextInt();
        int[][] checkpointArr = new int[numCheckpoint][2];
        for (int i = 0; i < numCheckpoint; i++) {
            checkpointArr[i][0] = input.nextInt();
            checkpointArr[i][1] = input.nextInt();
        }

        int distance = 0;
        for (int i = 0; i < numCheckpoint - 1; i++) {
            distance += Math.abs(checkpointArr[i][0] - checkpointArr[i+1][0]) + Math.abs(checkpointArr[i][1] - checkpointArr[i+1][1]);
        }

        int minDistance = distance;
        int oldSum; int newSum;
        for (int i = 1; i < numCheckpoint - 1; i++) {
            oldSum = Math.abs(checkpointArr[i-1][0] - checkpointArr[i][0]) + Math.abs(checkpointArr[i-1][1] - checkpointArr[i][1])
                    + Math.abs(checkpointArr[i][0] - checkpointArr[i+1][0]) + Math.abs(checkpointArr[i][1] - checkpointArr[i+1][1]);
            newSum = Math.abs(checkpointArr[i-1][0] - checkpointArr[i+1][0]) + Math.abs(checkpointArr[i-1][1] - checkpointArr[i+1][1]);
            if (oldSum <= newSum) {
                continue;
            }
            minDistance = Math.min(minDistance, distance - (oldSum - newSum));
        }

        System.out.print(minDistance);
    }
}

/**
 for (int i = 0; i < numCheckpoint; i++) {
 System.out.println(checkpointArr[i][0] + " " + checkpointArr[i][1]);
 }
 */