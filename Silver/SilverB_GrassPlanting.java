import java.util.Scanner;

 public class SilverB_GrassPlanting {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int numFields = input.nextInt();
         int[] connections = new int[numFields + 1];
         int x;
         int y;
         for (int i = 0; i < numFields - 1; i++) {
             x = input.nextInt();
             y = input.nextInt();
             connections[x]++;
             connections[y]++;
         }

         int max = 0;
         for (int i = 0; i < connections.length; i++) {
             if (connections[i] > max) {
                 max = connections[i];
             }
         }
         System.out.print(max+1);
     }

     public static void swap(int[] array, int one, int two) {
         int temp = array[one];
         array[one] = array[two];
         array[two] = temp;
     }
 }


