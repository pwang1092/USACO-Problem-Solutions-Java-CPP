import java.util.Scanner;

 public class SilverB_QuickSort {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int length = input.nextInt();
         int[] array = new int[length];
         for (int i = 0; i < length; i++) {
             array[i] = input.nextInt();
         }

         quickSort(array, 0, length-1);
         for (int g = 0; g < array.length; g++) {
             System.out.print(array[g] + " ");
         }
     }

     public static void quickSort(int[] array, int left, int right) {
         if (left >= right) {
             return;
         }
         int pivot = array[right];
         int i = left;
         int j = right - 1; // exclude pivot
         while(true) {
             while (i < array.length && array[i] < pivot) {
                 i++;
             }
             while(j >= 0 && array[j] > pivot) {
                 j--;
             }
             if (i >= j) {
                 break;
             }
             swap(array, i, j);
             i++;
             j--;
         }

         swap(array, i, right);
         for (int g = 0; g < array.length; g++) {
             System.out.print(array[g] + " ");
         }
         System.out.println();
         quickSort(array, left, i-1);
         quickSort(array, i+1, right);
     }

     public static void swap(int[] array, int one, int two) {
         int temp = array[one];
         array[one] = array[two];
         array[two] = temp;
     }
 }


