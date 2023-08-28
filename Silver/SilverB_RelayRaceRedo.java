import java.util.*;
import java.lang.*;

public class SilverB_RelayRaceRedo {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int[] duration = new int[numCows];
        ArrayList<ArrayList<Integer>> signals = new ArrayList<>();

        // make a duration array and arraylist of signals
        int numSignals;
        for (int i = 0; i < numCows; i++) {
            duration[i] = input.nextInt();
            signals.add(new ArrayList<>());
            numSignals = input.nextInt();
            for (int j = 0; j < numSignals; j++) {
                signals.get(i).add(input.nextInt() - 1);
            }
        }



        int waiting = 1; int running = 2; int done = 3;
        int[] state = new int[numCows];
        for (int i = 0; i < numCows; i++) {
            state[i] = waiting;
        } state[0] = running; // all the states are waiting except the first
        int[] finish = new int[numCows]; finish[0] = duration[0];

        for (int i = 0; i < numCows; i++) { // as many cows
            int finisher = -1;
            /** see which cow comes back first */
            for (int j = 0; j < numCows; j++) { // check all the cows in the array
                if (state[j] == running && (finisher == -1 || finish[j] < finish[finisher])) {
                    finisher = j;
                }
            }
            /** he is done */
            state[finisher] = done;
            /** signal the other cows and add their finish times*/
            for (int j = 0; j < signals.get(finisher).size(); j++) {
                int other = signals.get(finisher).get(j);
                if (state[other] == waiting) {
                    state[other] = running;
                    finish[other] = finish[finisher] + duration[other];
                }
            }
        }


        int max = 0;
        for (int i = 0; i < finish.length; i++) {
            max = Math.max(max, finish[i]);
        }
        System.out.print(max);
    }
}

/**
 for (int i = 0; i < numCows; i++) {
 System.out.print(duration[i] + " ");
 for (int j = 0; j < signals.get(i).size(); j++) {
 System.out.print(signals.get(i).get(j) + " ");
 }
 System.out.println();
 }
 */