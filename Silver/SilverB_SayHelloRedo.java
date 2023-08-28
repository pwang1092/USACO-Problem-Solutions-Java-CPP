import java.util.*;

public class SilverB_SayHelloRedo {

    public static void main(String[] args) {
        ArrayList<Integer> bessiePos = new ArrayList<>();
        ArrayList<Integer> elsiePos = new ArrayList<>();

        /** 1. scan input */
        Scanner input = new Scanner(System.in);
        int numBessieMoves = input.nextInt();
        int numElsieMoves = input.nextInt();

        /** put them into respective pos at time arrays */

        // bessie
        bessiePos.add(0);
        char direction;
        int distance;
        int pos = 0;
        for (int i = 0; i < numBessieMoves; i++) {
            distance = input.nextInt();
            direction = input.next().charAt(0);
            if (direction == 'R') {
                for (int j = 1; j <= distance; j++) {
                    bessiePos.add(pos + j);
                }
                pos = pos + distance;
            }
            else if (direction == 'L') {
                for (int j = 1; j <= distance; j++) {
                    bessiePos.add(pos-j);
                }
                pos = pos - distance;
            }
        }

        // elsie
        elsiePos.add(0);
        pos = 0;
        for (int i = 0; i < numElsieMoves; i++) {
            distance = input.nextInt();
            direction = input.next().charAt(0);
            if (direction == 'R') {
                for (int j = 1; j <= distance; j++) {
                    elsiePos.add(pos + j);
                }
                pos = pos + distance;
            }
            else if (direction == 'L') {
                for (int j = 1; j <= distance; j++) {
                    elsiePos.add(pos-j);
                }
                pos = pos - distance;
            }
        }

        /** make the sizes match */
        int last;
        int difference;
        if (bessiePos.size() > elsiePos.size()) {
            difference = bessiePos.size() - elsiePos.size();
            last = elsiePos.get(elsiePos.size()-1);
            for (int i = 0; i < difference; i++) {
                elsiePos.add(last);
            }
        }
        else if (elsiePos.size() > bessiePos.size()) {
            difference = elsiePos.size() - bessiePos.size();
            last = bessiePos.get(bessiePos.size()-1);
            for (int i = 0; i < difference; i++) {
                bessiePos.add(last);
            }
        }

        int ans = 0;
        boolean previouslySeparated = false;
        for (int i = 1; i < bessiePos.size(); i++) {
            if (bessiePos.get(i) == elsiePos.get(i)) {
                if (previouslySeparated) {
                    ans++;
                }
                previouslySeparated = false;
            }
            else {
                previouslySeparated = true;
            }
        }

        System.out.print(ans);
    }

}


/**
 for (Integer n: bessiePos) {
 System.out.print(n + " ");
 }
 System.out.println();
 for (Integer n: elsiePos) {
 System.out.print(n + " ");
 }
 System.out.println();
 System.out.println(bessiePos.size() + " " + elsiePos.size());
 */