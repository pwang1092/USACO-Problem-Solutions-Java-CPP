import java.util.*;

public class SilverB_BeautyPageant_Floodfill {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int columns = input.nextInt();
        char[][] matrix = new char[rows][columns];

        String nextLine;
        for (int i = 0; i < rows; i++) {
            nextLine = input.next();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = nextLine.charAt(j);
            }
        }

        ArrayList<SpotPoint> firstSpot = new ArrayList<>();
        ArrayList<SpotPoint> secondSpot = new ArrayList<>();

        // fill firstSpot arraylist with points from the first spot
        boolean done = false;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 'X') {
                    visited[i][j] = true;
                    floodfill(matrix, firstSpot, visited, i, j);
                    done = true;
                    break;
                }
            }
            if (done)
                break;
        }

        done = false;
        // fill secondSpot arraylist with points from second spot
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    floodfill(matrix, secondSpot, visited, i, j);
                    done = true;
                    break;
                }
            }
            if (done)
                break;
        }

        int minDistance = 500;
        int distance;
        for (int i = 0; i < firstSpot.size(); i++) {
            for (int j = 0; j < secondSpot.size(); j++) {
                distance = Math.abs(firstSpot.get(i).x - secondSpot.get(j).x)
                        + Math.abs(firstSpot.get(i).y - secondSpot.get(j).y);
                minDistance = Math.min(minDistance, distance);
            }
        }
        System.out.print(minDistance-1);
    }

    public static void floodfill(char[][] matrix, ArrayList<SpotPoint> spot, boolean[][] visited, int x, int y) {
        spot.add(new SpotPoint(x, y));

        if (inBounds(matrix, x, y+1) && !visited[x][y+1]) {
            if (matrix[x][y+1] == 'X') {
                visited[x][y+1] = true;
                floodfill(matrix, spot, visited, x, y + 1);
            }
        }
        if (inBounds(matrix, x+1, y) && !visited[x+1][y]) {
            if (matrix[x+1][y] == 'X') {
                visited[x+1][y] = true;
                floodfill(matrix, spot, visited, x + 1, y);
            }
        }
        if (inBounds(matrix, x-1, y) && !visited[x-1][y]) {
            if (matrix[x-1][y] == 'X') {
                visited[x-1][y] = true;
                floodfill(matrix, spot, visited, x - 1, y);
            }
        }
        if (inBounds(matrix, x, y-1) && !visited[x][y-1]) {
            if (matrix[x][y-1] == 'X') {
                visited[x][y-1] = true;
                floodfill(matrix, spot, visited, x, y - 1);
            }
        }
    }
    public static boolean inBounds(char[][] matrix, int x, int y) {
        if (x >= 0 && x < matrix.length && y >=0 && y < matrix[0].length) {
            return true;
        }
        return false;
    }
}

class SpotPoint {
    int x;
    int y;

    public SpotPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 for (int i = 0; i < rows; i++) {
 for (int j = 0; j < columns; j++) {
 System.out.print(matrix[i][j]);
 }
 System.out.println();
 }
 */