import java.util.Scanner;
import java.util.*;

public class Bronze_CowInCorner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numPieces = input.nextInt();
        int maxPurchaseSize = input.nextInt();

        int[] pieces = new int[numPieces];
        for (int i = 0; i < numPieces; i++) {
            pieces[i] = input.nextInt();
        }

        double max = 0;
        int[] maxes = new int[3];
        boolean increasing = true;
        boolean done = false;

        for (int i = pieces.length-1; i >= 0; i--) {
            if (done) {
                break;
            }
            for (int j = i-1; j >= 0; j--) {
                if (done) {
                    break;
                }
                for (int k = j-1; k >= 0; k--) {

                    if (validTriangle(pieces[i], pieces[j], pieces[k])) {

                        if (area(pieces[i], pieces[j], pieces[k]) > max) {
                            max = area(pieces[i], pieces[j], pieces[k]);
                            maxes[0] = pieces[i]; maxes[1] = pieces[j]; maxes[2] = pieces[k];
                        }
                        else {
                            increasing = false;
                        }
                    }

                }

                for (int buy = i - j + 1; buy < maxPurchaseSize && buy < pieces[i] + pieces[j]; buy++) {
                    if (area(pieces[i], pieces[j], buy) > max) {
                        max = area(pieces[i], pieces[j], buy);
                        maxes[0] = pieces[i]; maxes[1] = pieces[j]; maxes[2] = buy;
                    }
                }
                if (!increasing) {
                    done = true;
                    break;
                }
            }
        }

        Arrays.sort(maxes);
        for (int i = 0; i < 3; i++) {
            System.out.print(maxes[i] + " ");
        }
    }

    public static boolean validTriangle(int one, int two, int three) {
        if (one + two <= three) {
            return false;
        }
        if (one + three <= two) {
            return false;
        }
        if (two + three <= one) {
            return false;
        }
        return true;
    }
    public static double area(int one, int two, int three) {
        double s = (one + two + three) / 2.0;
        return s * (s - one) * (s - two) * (s - three);
    }
}

//                        System.out.print(i + " " + j + " " + k + area(i, j, k));