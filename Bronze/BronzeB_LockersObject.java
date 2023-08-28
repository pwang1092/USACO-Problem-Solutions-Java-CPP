import java.util.*;
import java.lang.*;

public class BronzeB_LockersObject {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int startT;
        int endT;
        int value;
        ArrayList<LockerPoint> array = new ArrayList<>();
        for (int i = 0; i < numCows; i++) {
            startT = input.nextInt();
            endT = input.nextInt();
            value = input.nextInt();
            array.add(new LockerPoint(startT, value));
            array.add(new LockerPoint(endT, -value));
        }

        Collections.sort(array, new sortByT());
        int maximum = 0;
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i).value;
            if (sum > maximum) {
                maximum = sum;
            }
        }
        System.out.print(maximum);
    }

    static class sortByT implements Comparator<LockerPoint> {
        public int compare(LockerPoint one, LockerPoint two) {
            if (one.position > two.position) {
                return 1;
            }
            return -1;
        }
    }
}

class LockerPoint {
    int position;
    int value;

    LockerPoint(int position, int value) {
        this.position = position;
        this.value = value;
    }
}
