import java.util.*;

public class SilverB_WorldDomination_Floodfill {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] matrix = new int[size+2][size+2];

        String string;
        for (int i = 1; i < matrix.length-1; i++) {
            string = input.next();
            for (int j = 1; j < matrix.length-1; j++) {
                if (string.charAt(j-1) == '.') {
                    matrix[i][j] = 0;
                }
                else {
                    matrix[i][j] = -1;
                }
            }
        }

        boolean[][] visited = new boolean[matrix.length][matrix.length];
        int index = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == -1 && !visited[i][j]) {
                    floodfill(matrix, i, j, index, visited);
                    visited[i][j] = true;
                    index++;
                }
            }
        }

        Land[] lands = new Land[index];
        for (int i = 0; i < index; i++) {
            lands[i] = new Land(0, 0);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    lands[matrix[i][j]-1].area++;

                    if (matrix[i][j+1] == 0) {
                        lands[matrix[i][j]-1].perimeter++;
                    }
                    if (matrix[i][j-1] == 0) {
                        lands[matrix[i][j]-1].perimeter++;
                    }
                    if (matrix[i+1][j] == 0) {
                        lands[matrix[i][j]-1].perimeter++;
                    }
                    if (matrix[i-1][j] == 0) {
                        lands[matrix[i][j]-1].perimeter++;
                    }
                }
            }
        }

        Arrays.sort(lands, new sort());
        System.out.print(lands[0].area + " " + lands[0].perimeter);
    }

    static class sort implements Comparator<Land> {
        public int compare(Land one, Land two) {
            if (one.area < two.area) {
                return 1;
            }
            else if (one.area == two.area && one.perimeter > two.perimeter) {
                return 1;
            }
            return -1;
        }
    }

    public static void floodfill(int[][] matrix, int x, int y, int index, boolean[][] visited) {
        matrix[x][y] = index;

        if (inBounds(matrix, x, y+1) && !visited[x][y+1]) {
            if (matrix[x][y+1] == -1) {
                visited[x][y+1] = true;
                floodfill(matrix, x, y+1, index, visited);
            }
        }
        if (inBounds(matrix, x+1, y) && !visited[x+1][y]) {
            if (matrix[x+1][y] == -1) {
                visited[x+1][y] = true;
                floodfill(matrix, x+1, y, index, visited);
            }
        }
        if (inBounds(matrix, x-1, y) && !visited[x-1][y]) {
            if (matrix[x-1][y] == -1) {
                visited[x-1][y] = true;
                floodfill(matrix, x-1, y, index, visited);
            }
        }
        if (inBounds(matrix, x, y-1) && !visited[x][y-1]) {
            if (matrix[x][y-1] == -1) {
                visited[x][y-1] = true;
                floodfill(matrix, x, y-1, index, visited);
            }
        }
    }

    public static boolean inBounds(int[][] matrix, int x, int y) {
        if (x >= 0 && x < matrix.length && y >=0 && y < matrix[0].length) {
            return true;
        }
        return false;
    }

}

class Land {
    int area;
    int perimeter;

    public Land(int area, int perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }
}

/**
 for (int i = 0; i < matrix.length; i++) {
 for (int j = 0; j < matrix.length; j++) {
 System.out.print(matrix[i][j]);
 }
 System.out.println();
 }
 */