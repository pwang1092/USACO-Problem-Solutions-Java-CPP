import java.util.*;
import java.lang.*;

public class BronzeB_ChineseBull {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        int size = input.nextInt(); // n
        int numPieces = input.nextInt(); // k
        String string;
        boolean[][][] array = new boolean[numPieces + 1][size][size];
        int[][] dimensions = new int[numPieces + 1][4];
        int left;
        int right;
        int bottom;
        int top;
        for (int i = 0; i < numPieces + 1; i++) {
            left = size - 1;
            right = 0;
            top = size - 1;
            bottom = 0;
            for (int j = 0; j < size; j++) {
                string = input.next();
                for (int k = 0; k < size; k++) {
                    if (string.substring(k, k + 1).equals("#")) {
                        array[i][j][k] = true;
                        /** find the outermost dimensions of the piece where there are #'s */
                        bottom = Math.max(bottom, j);
                        top = Math.min(top, j);
                        right = Math.max(right, k);
                        left = Math.min(left, k);
                    } else {
                        array[i][j][k] = false;
                    }
                }
            }
            dimensions[i] = new int[]{left, right, top, bottom};
        }

        /** try all pieces and shifts */
        boolean good = true;
        for (int piece1 = 1; piece1 < numPieces + 1; piece1++) { // choose the first piece

            for (int piece2 = piece1 + 1; piece2 < numPieces + 1; piece2++) { // choose the second piece

                /** all possible orientations */
                for (int ix1 = dimensions[piece1][3] - size + 1; ix1 <= dimensions[piece1][2]; ix1++) {
                    for (int iy1 = dimensions[piece1][1] - size + 1; iy1 <= dimensions[piece1][0]; iy1++) {
                        for (int ix2 = dimensions[piece2][3] - size + 1; ix2 <= dimensions[piece2][2]; ix2++) {
                            for (int iy2 = dimensions[piece2][1] - size + 1; iy2 <= dimensions[piece2][0]; iy2++) {

                                good = true;
                                for (int x = 0; x < size; x++) {
                                    for (int y = 0; y < size; y++) {
                                        boolean iPart = check(array, piece1, size, x + ix1, y + iy1);
                                        boolean jPart = check(array, piece2, size, x + ix2, y + iy2);
                                        /** check if overlap # */
                                        if (iPart && jPart) {
                                            good = false;
                                            break;
                                        }
                                        if (array[0][x][y] != (iPart || jPart)) {
                                            good = false;
                                            break;
                                        }
                                    }
                                    if (!good) {
                                        break;
                                    }
                                }
                                if (good) {
                                    System.out.println(piece1 + " " + piece2);
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean check(boolean[][][] array, int part, int size, int x, int y) {
        if(x >= 0 && x < size && y >= 0 && y < size && array[part][x][y]) {
            return true;
        }
        return false;
    }
}


//            // check if piece1 is oversized
//            x1 = dimensions[piece1][1] - dimensions[piece1][0] + 1;
//            y1 = dimensions[piece1][3] - dimensions[piece1][2] + 1;
//            if (x1 > frameX || y1 > frameY) {
//                continue;
//            }


// // check if piece2 is oversized
//                x2 = dimensions[piece2][1] - dimensions[piece2][0] + 1;
//                y2 = dimensions[piece2][3] - dimensions[piece2][2] + 1;
//                if (x2 > frameX || y2 > frameX) {
//                    continue;
//                }