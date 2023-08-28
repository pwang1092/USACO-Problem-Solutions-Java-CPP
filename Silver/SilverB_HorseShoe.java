import java.util.*;
import java.lang.*;

public class SilverB_HorseShoe {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        char[][] array = new char[length][length];
        String temp;
        for (int i = 0; i < length; i++) {
            temp = input.next();
            for (int j = 0; j < length; j++) {
                array[i][j] = temp.charAt(j);
            }
        }

        if (array[0][0] == ')') {
            System.out.print(0);
            System.exit(0);
        }

        boolean[][] visited = new boolean[length][length];
        visited[0][0] = true;
        int[] ans = new int[1];
        dfs(array, 0, 0, 1, 0, 1, visited, ans);
        System.out.print(ans[0]);
    }

    public static void dfs(char[][] matrix, int posX, int posY, int open, int closed, int current, boolean[][] visited, int[] ans) {
        if (open == closed) {
            ans[0] = Math.max(ans[0], 2*open);
            return;
        }

        if(posX + 1 < matrix.length && !visited[posX+1][posY]) {
            visited[posX + 1][posY] = true;
            if (matrix[posX+1][posY] == '(' && current == 1) {
                dfs(matrix, posX + 1, posY, open + 1, closed, 1, visited, ans);
            }
            else if (matrix[posX+1][posY] == ')') {
                dfs(matrix, posX + 1, posY, open, closed + 1, 2, visited, ans);
            }
            visited[posX + 1][posY] = false;
        }

        if(posX - 1 >= 0 && !visited[posX-1][posY]) {
            visited[posX - 1][posY] = true;
            if (matrix[posX-1][posY] == '(' && current == 1) {
                dfs(matrix, posX - 1, posY, open + 1, closed, 1, visited, ans);
            }
            else if (matrix[posX-1][posY] == ')') {
                dfs(matrix, posX - 1, posY, open, closed + 1, 2, visited, ans);
            }
            visited[posX - 1][posY] = false;
        }

        if(posY + 1 < matrix.length && !visited[posX][posY+1]) {
            visited[posX][posY+1] = true;
            if (matrix[posX][posY+1] == '(' && current == 1) {
                dfs(matrix, posX, posY+1, open + 1, closed, 1, visited, ans);
            }
            else if (matrix[posX][posY+1] == ')') {
                dfs(matrix, posX, posY+1, open, closed + 1, 2, visited, ans);
            }
            visited[posX][posY+1] = false;
        }

        if(posY - 1 >= 0 && !visited[posX][posY-1]) {
            visited[posX][posY-1] = true;
            if (matrix[posX][posY-1] == '(' && current == 1) {
                dfs(matrix, posX, posY-1, open + 1, closed, 1, visited, ans);
            }
            else if (matrix[posX][posY-1] == ')') {
                dfs(matrix, posX, posY-1, open, closed + 1, 2, visited, ans);
            }
            visited[posX][posY-1] = false;
        }

    }
}

/**
 for (int i = 0; i < length; i++) {
 for (int j = 0; j < length; j++) {
 System.out.print(array[i][j]);
 }
 System.out.println();
 }
 */