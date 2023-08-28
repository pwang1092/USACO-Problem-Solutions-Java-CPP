import java.util.*;

public class SilverB_NoCow {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        int numMissingCows = input.nextInt();
        int cowNumber = input.nextInt();
        String buffer = input.nextLine();

        String string;
        String[][] list = new String[numMissingCows][]; // adjectives stored under cow. Traverse columns later

        /** 2. use .split to read line by line into a 2-D string array */
        for (int i = 0; i < numMissingCows; i++) {
            list[i] = input.nextLine().split("\\s");
        }

        /** 3. only keep the adjectives */
        ArrayList<ArrayList<String>> adjectiveList = new ArrayList<>();
        int index = 0;
        for (int i = 4; i < list[0].length-1; i++) { // for each column
            adjectiveList.add(new ArrayList<>());
            for (int j = 0; j < numMissingCows; j++) { // go through each row
                if (!alreadyAppears(list, j, i, list[j][i])) { // test if it already appears
                    adjectiveList.get(adjectiveList.size()-1).add(list[j][i]);
                }
            }
        }

        /** 4. sort each row */
        for (int i = 0; i < adjectiveList.size(); i++) {
            Collections.sort(adjectiveList.get(i));
        }

        /** 5. get coefficients, place values */
        int numberCowsExist = 1;
        int[] coefficient = new int[adjectiveList.size()];
        for (int i = 0; i < adjectiveList.size(); i++) {
            numberCowsExist *= adjectiveList.get(i).size();
        }
        for (int i = 0; i < adjectiveList.size(); i++) {
            coefficient[i] = numberCowsExist / adjectiveList.get(i).size();
            numberCowsExist = coefficient[i];
        }

        /** 6. get missing cow values, and sort*/
        ArrayList<Integer> missingCowValues = new ArrayList<>();
        for (int i = 0; i < numMissingCows; i++) {
            int value = 0;
            for (int j = 4; j < list[i].length-1; j++) {
                for (int t = 0; t < adjectiveList.get(j-4).size(); t++) {
                    if (adjectiveList.get(j-4).get(t).equals(list[i][j])) {
                        value += coefficient[j-4] * t;
                        break;
                    }
                }
            }
            missingCowValues.add(value);
        }

        Collections.sort(missingCowValues);

        int counter = 1;
        int finalNumber = cowNumber;
        while (counter < cowNumber) {
            boolean found = false;
            for (int i = 0; i < missingCowValues.size(); i++) {
                if (missingCowValues.get(i) == counter) {
                    found = true;
                }
            }
            if (found) {
                finalNumber++;
            }
            counter++;
        }


        for (int i = 0; i < adjectiveList.size(); i++) {
            int temp = finalNumber / coefficient[i];
            System.out.print(adjectiveList.get(i).get(temp) + " ");
            finalNumber %= coefficient[i];
        }
    }

    public static boolean alreadyAppears(String[][] list, int row, int column, String word) {
        for (int i = 0; i < row; i++) {
            if (list[i][column].equals(word)) {   // see if the word appears in previous cow rows
                return true;
            }
        }
        return false;
    }

}

/**
 for (int i = 0; i < adjectiveList.size(); i++) {
 for (int j = 0; j < adjectiveList.get(i).size(); j++) {
 System.out.print(adjectiveList.get(i).get(j) + " ");
 }
 System.out.println();
 }
 */