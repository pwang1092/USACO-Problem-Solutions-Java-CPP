import java.util.*;

public class SilverB_Moobuzz {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        int nthNumber = input.nextInt();
        int numBlocks = nthNumber / 8;
        int remainder = nthNumber % 8;

        int[] remainderValue = new int[]{1, 2, 4, 7, 8, 11, 13, 14};

        int ans;
        if (nthNumber % 8 == 0) {
            ans = 15 * numBlocks - 1;
        }
        else{
            ans = numBlocks * 15 + remainderValue[remainder - 1];
        }
        System.out.print(ans);
    }
}

/**
 for (int i = 0; i < numCheckpoint; i++) {
 System.out.println(checkpointArr[i][0] + " " + checkpointArr[i][1]);
 }
 */