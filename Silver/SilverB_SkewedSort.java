import java.util.Scanner;

 public class SilverB_SkewedSort {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int power = input.nextInt();
         int length = (int) Math.pow(2, power);
         int[] array = new int[length];
         for (int i = 0; i < length; i++) {
             array[i] = input.nextInt();
         }

         int[] total = new int[]{0};
         skewedSearch(array, 0, array.length-1, total);
     }

     public static void skewedSearch(int[] array, int left, int right, int[] total) {
         if (left >= right) {
             return;
         }
         int mid = (left + right)/2;
         skewedSearch(array, left, mid, total);
         skewedSearch(array, mid+1, right, total);

         int length = mid - left + 1;
         boolean swapNeeded = false;
         for (int i = left; i <= mid; i++) {
             if (array[i] < array[i+length]) {
                 break;
             }
             else if (array[i] > array[i+length]) {
                 swapNeeded = true;
                 break;
             }
         }


         int temp;
         if (swapNeeded) {
             for (int i = left; i <= mid; i++) {
                 temp = array[i];
                 array[i] = array[i+length];
                 array[i+length] = temp;
             }
             total[0] += 2 * length * length;
         }

         if (left == 0 && right == array.length-1) {
             System.out.println(total[0]);
             for (int i = 0; i < array.length; i++) {
                 System.out.println(array[i]);
             }
         }
     }
 }


