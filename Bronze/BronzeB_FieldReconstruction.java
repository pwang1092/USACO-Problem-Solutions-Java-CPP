import java.util.*;
import java.lang.*;

public class BronzeB_FieldReconstruction {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int[][] array = new int[numCows][2];
        for (int i = 0; i < numCows; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = input.nextInt();
            }
        }

        // solve problem

        Arrays.sort(array, new sortByX());
        int minX = array[0][0];
        int maxX = array[numCows-1][0];
        Arrays.sort(array, new sortByY());
        int minY = array[0][1];
        int maxY = array[numCows-1][1];
        int minArea = (maxX-minX)*(maxY-minY);

        int tempMinX;
        int tempMaxX;
        int tempMinY;
        int tempMaxY;

        // copy
        ArrayList<int[]> newArray = new ArrayList<>();
        for (int i = 0; i < numCows; i++) {
            // remove possible minimizers
            if (array[i][1] == minY) {
                for (int j = 0; j < numCows; j++) {
                    if (j == i) {
                        continue;
                    }
                    newArray.add(array[j]);
                }
                Collections.sort(newArray, new sortByX());
                tempMinX = newArray.get(0)[0];
                tempMaxX = newArray.get(newArray.size() - 1)[0];
                Collections.sort(newArray, new sortByY());
                tempMinY = newArray.get(0)[1];
                tempMaxY = newArray.get(newArray.size() - 1)[1];
                if ((tempMaxX - tempMinX) * (tempMaxY - tempMinY) < minArea) {
                    minArea = (tempMaxX - tempMinX) * (tempMaxY - tempMinY);
                }
                newArray.clear();
            }
            else if (array[i][1] == maxY) {
                for (int j = 0; j < numCows; j++) {
                    if (j == i) {
                        continue;
                    }
                    newArray.add(array[j]);
                }
                Collections.sort(newArray, new sortByX());
                tempMinX = newArray.get(0)[0];
                tempMaxX = newArray.get(newArray.size() - 1)[0];
                Collections.sort(newArray, new sortByY());
                tempMinY = newArray.get(0)[1];
                tempMaxY = newArray.get(newArray.size() - 1)[1];
                if ((tempMaxX - tempMinX) * (tempMaxY - tempMinY) < minArea) {
                    minArea = (tempMaxX - tempMinX) * (tempMaxY - tempMinY);
                }
                newArray.clear();
            }

            Arrays.sort(array, new sortByX());
            if (array[i][0] == minX) {
                for (int j = 0; j < numCows; j++) {
                    if (j == i) {
                        continue;
                    }
                    newArray.add(array[j]);
                }
                Collections.sort(newArray, new sortByX());
                tempMinX = newArray.get(0)[0];
                tempMaxX = newArray.get(newArray.size() - 1)[0];
                Collections.sort(newArray, new sortByY());
                tempMinY = newArray.get(0)[1];
                tempMaxY = newArray.get(newArray.size() - 1)[1];
                if ((tempMaxX - tempMinX) * (tempMaxY - tempMinY) < minArea) {
                    minArea = (tempMaxX - tempMinX) * (tempMaxY - tempMinY);
                }
                newArray.clear();
            }
            else if (array[i][0] == maxX) {
                for (int j = 0; j < numCows; j++) {
                    if (j == i) {
                        continue;
                    }
                    newArray.add(array[j]);
                }
                Collections.sort(newArray, new sortByX());
                tempMinX = newArray.get(0)[0];
                tempMaxX = newArray.get(newArray.size() - 1)[0];
                Collections.sort(newArray, new sortByY());
                tempMinY = newArray.get(0)[1];
                tempMaxY = newArray.get(newArray.size() - 1)[1];
                if ((tempMaxX - tempMinX) * (tempMaxY - tempMinY) < minArea) {
                    minArea = (tempMaxX - tempMinX) * (tempMaxY - tempMinY);
                }
                newArray.clear();
            }

        }
        System.out.print(minArea);
    }

    /** sort by x and sort by y comparators */
    static class sortByX implements Comparator<int[]> {
        public int compare(int[] one, int[] two) {
            if (one[0] > two[0]) {
                return 1;
            }
            else
                return -1;
        }
    }
    static class sortByY implements Comparator<int[]> {
        public int compare(int[] one, int[] two) {
            if (one[1] > two[1]) {
                return 1;
            }
            else
                return -1;
        }
    }
}






