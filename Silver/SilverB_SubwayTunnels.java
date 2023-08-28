import java.util.*;
import java.lang.*;

public class SilverB_SubwayTunnels {
    public static void main(String[] args) {
        /** scan input */
        Scanner input = new Scanner(System.in);
        int numTunnels = input.nextInt();
        int numConnections = input.nextInt();
        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();

        int temp1; int temp2;
        for (int i = 0; i < numTunnels; i++) {
            connections.add(new ArrayList<>());
        }
        for (int i = 0; i < numConnections; i++) {
            temp1 = input.nextInt() - 1;
            temp2 = input.nextInt() - 1;
            connections.get(temp1).add(temp2);
            connections.get(temp2).add(temp1);
        }

        boolean[] visited = new boolean[numTunnels]; visited[0] = true;
        dfs(0, connections, visited);

        int count = 0;
        for (int i = 0; i < numTunnels; i++) {
            if (!visited[i]) {
                System.out.println(i + 1);
                count++;
            }
        }
        if (count == 0) {
            System.out.print("0");
        }
    }

    public static void dfs(int position, ArrayList<ArrayList<Integer>> connections, boolean[] visited) {
        int next;
        for (int i = 0; i < connections.get(position).size(); i++) {
            next = connections.get(position).get(i);
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, connections, visited);
            }
        }
    }
}

/**
 for (int i = 0; i < connections.size(); i++) {
 for (int j = 0; j < connections.get(i).size(); j++) {
 System.out.print(connections.get(i).get(j) + " ");
 }
 System.out.println();
 }
 */