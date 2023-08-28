import java.util.*;
import java.lang.*;

public class BronzeB_ModernArt {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        String line;
        int[][] canvas = new int[size][size];
        for (int i = 0; i < size; i++) {
            line = input.next();
            for (int j = 0; j < size; j++) {
                canvas[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        // find visible colors
        int numVisible = 0;
        ArrayList<Integer> visibleColors = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < visibleColors.size(); k++) {
                    if (canvas[i][j] == visibleColors.get(k)) {
                        found = true;
                        break;
                    }
                }
                if (!found ) {
                    visibleColors.add(canvas[i][j]);
                    numVisible++;
                }
                found = false;
            }
        }

        Collections.sort(visibleColors);

        int[][] border = new int[10][4];
        for (int i = 0; i < 10; i++) {
            border[i][0] = size; // min R
            border[i][1] = size; // min C
            border[i][2] = -1; // max R
            border[i][3] = -1; // max C
        }

        int color;
        for (int i = 0; i < size; i++) { // row
            for (int j = 0; j < size; j++) { // column
                color = canvas[i][j];
                if ( i < border[color][0] ) { // min R
                    border[color][0] = i;
                }
                if ( j < border[color][1] ) { // min C
                    border[color][1] = j;
                }
                if ( i > border[color][2]) { // max R
                    border[color][2] = i;
                }
                if ( j > border[color][3] ) { // max C
                    border[color][3] = j;
                }
            }
        }

        boolean[] notLast = new boolean[10];
        for (int j = 0; j < numVisible; j++) {
            notLast[visibleColors.get(j)] = true;
        }
        if (visibleColors.get(0) == 0) {
            notLast[0] = false;
        }

        for (int i = 0; i < numVisible ; i++) {
            if (visibleColors.get(i) == 0) {
                continue;
            }
            for (int j = border[visibleColors.get(i)][0]; j <= border[visibleColors.get(i)][2]; j++) {
                for (int k = border[visibleColors.get(i)][1]; k <= border[visibleColors.get(i)][3]; k++) {
                    if (canvas[j][k] != visibleColors.get(i)) {
                        notLast[canvas[j][k]] = false;
                    }
                }
            }
        }

        int sum=0;
        for (int i = 0; i < 10; i++) {
            if (notLast[i]) {
                sum++;
            }
        }
        System.out.print(sum);
    }
}


//System.out.println(border[visibleColors.get(i)][0]+" "+border[visibleColors.get(i)][2]+" "+border[visibleColors.get(i)][1]+" "+border[visibleColors.get(i)][3]);
//                    System.out.println(canvas[j][k] + " " + visibleColors.get(i));
