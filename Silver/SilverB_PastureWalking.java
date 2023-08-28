import java.util.Scanner;

public class SilverB_PastureWalking {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numPastures = input.nextInt();
        int numQueries = input.nextInt();
        int[][] matrix = new int[numPastures][numPastures];

        int p1; int p2;
        for (int i = 0; i < numPastures - 1; i++) {
            p1 = input.nextInt() - 1; p2 = input.nextInt() - 1;
            matrix[p1][p2] = input.nextInt();
            matrix[p2][p1] = matrix[p1][p2];
        }

        int[][] queries = new int[numQueries][2];
        for (int i = 0; i < numQueries; i++) {
            queries[i][0] = input.nextInt() - 1;
            queries[i][1] = input.nextInt() - 1;
        }

        int[] ans = new int[1];
        boolean[] done = new boolean[]{false};
        /** visited array to keep from adding distance on the way back */
        boolean[] visited = new boolean[numPastures];

        for (int i = 0; i < numQueries; i++) {
            done[0] = false; ans[0] = 0;
            visited[queries[i][0]] = true;
            dps(matrix, visited, queries[i][0], queries[i][1], ans, done);
            visited[queries[i][0]] = false;
            System.out.println(ans[0]);
        }

    }

    public static void dps(int[][] matrix, boolean[] visited, int current, int destination, int[] ans, boolean[] done) {
        if (done[0]) {
            return;
        }
        if (current == destination) {
            done[0] = true;
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[current][i] != 0 && !visited[i]) { // cannot be zero and cannot be visited
                visited[i] = true;
                dps(matrix, visited, i, destination, ans, done);
                visited[i] = false; // unmark
                if (done[0]) {
                    ans[0] += matrix[current][i];
                    break;
                }
            }
        }
    }
}

/**
for (int i = 0; i < numPastures; i++) {
        for (int j = 0; j < numPastures; j++) {
        System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
        }
 */