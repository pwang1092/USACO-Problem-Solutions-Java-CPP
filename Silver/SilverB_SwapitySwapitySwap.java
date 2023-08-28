import java.lang.reflect.Array;
import java.util.*;

public class SilverB_SwapitySwapitySwap {
    public static void main(String[] args) {
        /** 1. scan the input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int numPairs = input.nextInt();
        int numRepetitions = input.nextInt();

        int[] array = new int[numCows+1];
        for (int i = 0; i < numCows+1; i++) {
            array[i] = i;
        }

        /** swap first iteration */
        int left; int right; int temp;
        for (int i = 0; i < numPairs; i++) {
            left = input.nextInt();
            right = input.nextInt();

            for (int j = 0; j < (right-left+1)/2; j++) {
                temp = array[left+j];
                array[left+j] = array[right-j];
                array[right-j] = temp;
            }
        }


        int index; boolean[] visited = new boolean[numCows+1];
        int mod;
        ArrayList<Integer> cycles = new ArrayList<>();
        for (int i = 1; i <= numCows; i++) { // go through all indexes
            if (!visited[i]) { // check if visited
                visited[i] = true; // if not, mark visited
                cycles.add(i); // add the current point
                index = i;
                while (array[index] != i) {
                    visited[index] = true; // go through cycle
                    cycles.add(array[index]);
                    index = array[index];
                }
                visited[index] = true; // mark final point

                mod = numRepetitions % cycles.size(); // remainder
                for (int j = 0; j < cycles.size(); j++) {
                    array[cycles.get(j)] = cycles.get( (j+mod)%cycles.size()); // modular arithmetic to place numbers
                }
                cycles.clear(); // clear cycles for future use
            }
        }

        for (int i = 1; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}


/**
 for (int i = 0; i < array.length; i++) {
 System.out.print(array[i] + " ");
 }
 */