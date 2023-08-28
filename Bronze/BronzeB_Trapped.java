import java.util.*;
import java.lang.*;

public class BronzeB_Trapped {
    public static void main(String[] args) {
        /** receive input */
        Scanner input = new Scanner(System.in);
        int numBales = input.nextInt();
        haybale[] baleArray = new haybale[numBales];
        for (int i = 0; i < numBales; i++) {
            baleArray[i] = new haybale(input.nextInt(), input.nextInt());
        }

        Arrays.sort(baleArray, new sortByPosition());
        int left;
        int right;
        int distance;
        boolean ext = false;
        int total = 0;
        for (int sp = 0; sp < numBales - 1; sp++) {
            left = sp;
            right = sp + 1;
            while (true) {
                ext = false;
                distance = baleArray[right].position - baleArray[left].position;
                if (right < numBales && distance > baleArray[right].size) {
                    right++;
                    ext = true;
                }
                if (left > -1 && distance > baleArray[left].size) {
                    left--;
                    ext = true;
                }
                if (left == -1 || right == numBales) {
                    break;
                }
                if (!ext) {
                    total += baleArray[sp+1].position - baleArray[sp].position;
                    break;
                }
            }
        }
        System.out.print(total);

    }
    public static class sortByPosition implements Comparator<haybale> {
        public int compare(haybale one, haybale two) {
            if (one.position > two.position) {
                return 1;
            }
            else
                return -1;
        }
    }
}

class haybale {
    int position;
    int size;

    haybale(int size, int position) {
        this.position = position;
        this.size = size;
    }
}
