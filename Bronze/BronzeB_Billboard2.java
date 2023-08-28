import java.util.*;
import java.lang.*;

public class BronzeB_Billboard2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int board1LX = input.nextInt() + 1000;
        int board1LY = input.nextInt() + 1000;
        int board1RX = input.nextInt() + 1000;
        int board1UY = input.nextInt() + 1000;
        int board2LX = input.nextInt() + 1000;
        int board2LY = input.nextInt() + 1000;
        int board2RX = input.nextInt() + 1000;
        int board2UY = input.nextInt() + 1000;
        int truckLX = input.nextInt() + 1000;
        int truckLY = input.nextInt() + 1000;
        int truckRX = input.nextInt() + 1000;
        int truckUY = input.nextInt() + 1000;

        int area = (board1RX-board1LX)*(board1UY-board1LY) + (board2RX-board2LX)*(board2UY-board2LY);

        if (noOverlap(board1LX, board1LY, board1RX, board1UY, truckLX, truckLY, truckRX, truckUY)) {
            area += 0;
        }
        else {
            int xL = Math.max(board1LX, truckLX);
            int xR = Math.min(board1RX, truckRX);
            int yL = Math.max(board1LY, truckLY);
            int yU = Math.min(board1UY, truckUY);
            area -= (xR-xL)*(yU-yL);
        }

        if (noOverlap(board2LX, board2LY, board2RX, board2UY, truckLX, truckLY, truckRX, truckUY)) {
            area += 0;
        }
        else {
            int xL = Math.max(board2LX, truckLX);
            int xR = Math.min(board2RX, truckRX);
            int yL = Math.max(board2LY, truckLY);
            int yU = Math.min(board2UY, truckUY);
            area -= (xR-xL)*(yU-yL);
        }

        System.out.print(area);
    }

    public static boolean noOverlap(int X1, int Y1, int X2, int Y2, int x1, int y1, int x2, int y2) {
        if (X2 < x1 ) {
            return true;
        }
        else if (X1 > x2) {
            return true;
        }
        else if (Y1 > y2) {
            return true;
        }
        else if (Y2 < y1) {
            return true;
        }
        else
            return false;
    }
}


