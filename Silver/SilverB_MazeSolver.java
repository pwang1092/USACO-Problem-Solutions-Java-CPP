import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

public class SilverB_MazeSolver {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int columns = input.nextInt();
        char[][] maze = new char[rows][columns];

        String temp;
        int startX = 0; int startY = 0; int endX = 0; int endY = 0;
        for (int i = 0; i < rows; i++) {
            temp = input.next();
            for (int j = 0; j < columns; j++) {
                maze[i][j] = temp.charAt(j);
                if (maze[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                else if (maze[i][j] == 'F') {
                    endX = i;
                    endY = j;
                }
            }
        }

        ArrayList<Character> path = new ArrayList<>();
        boolean[] done = new boolean[1];
        boolean[][] visited = new boolean[rows][columns];

        matrixSearch(maze, startX, startY, endX, endY, path, done, visited);
        for(int n = 0; n < path.size(); n++) {
            System.out.print(path.get(n));
        }
    }

    public static void matrixSearch(char[][] matrix, int startX, int startY, int endX, int endY, ArrayList<Character> path, boolean[] done, boolean[][] visited) {
        if (done[0]) {
            return;
        }
        if (startX == endX && startY == endY) {
            done[0] = true;
            return;
        }

        if (!done[0] && startX+1 < matrix.length && matrix[startX+1][startY] != '#' && !visited[startX+1][startY]) {
            path.add('D');
            visited[startX+1][startY] = true;
            matrixSearch(matrix, startX + 1, startY, endX, endY, path, done, visited);
            if (!done[0]) {
                path.remove(path.size() - 1);
            }
        }
        if (!done[0] && startY+1 < matrix[0].length && matrix[startX][startY+1] != '#' && !visited[startX][startY+1]) {
            path.add('R');
            visited[startX][startY+1] = true;
            matrixSearch(matrix, startX, startY + 1, endX, endY, path, done, visited);
            if (!done[0]) {
                path.remove(path.size() - 1);
            }
        }
        if (!done[0] && startX-1 >= 0 && matrix[startX-1][startY] != '#' && !visited[startX-1][startY]) {
            path.add('U');
            visited[startX-1][startY] = true;
            matrixSearch(matrix, startX-1, startY, endX, endY, path, done, visited);
            if (!done[0]) {
                path.remove(path.size() - 1);
            }
        }
        if (!done[0] && startY-1 >= 0 && matrix[startX][startY-1] != '#' && !visited[startX][startY-1]) {
            path.add('L');
            visited[startX][startY-1] = true;
            matrixSearch(matrix, startX, startY - 1, endX, endY, path, done, visited);
            if (!done[0]) {
                path.remove(path.size() - 1);
            }
        }
    }
}

/**
 for (int i = 0; i < rows; i++) {
 for (int j = 0; j < columns; j++) {
 System.out.print(maze[i][j]);
 }
 System.out.println();
 }
 System.out.print(startX + " " + startY + " " + endX + " " + endY);
 */