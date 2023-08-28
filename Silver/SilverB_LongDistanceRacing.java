import java.util.*;

public class SilverB_LongDistanceRacing {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        int timeLimit = input.nextInt();
        int distance = input.nextInt();
        int upTime = input.nextInt();
        int flatTime = input.nextInt();
        int downTime = input.nextInt();

        char[] path = new char[distance];
        for (int i = 0; i < distance; i++) {
            path[i] = input.next().charAt(0);
        }

        int time = 0;
        int ans = 0;
        for (int i = 0; i < distance; i++) {
            if (path[i] == 'u' || path[i] == 'd') {
                time += upTime + downTime;
            }
            else if (path[i] == 'f') {
                time += flatTime * 2;
            }
            if (time > timeLimit) {
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}

/**
 for (int i = 0; i < distance; i++) {
 System.out.println(path[i]);
 }
 */