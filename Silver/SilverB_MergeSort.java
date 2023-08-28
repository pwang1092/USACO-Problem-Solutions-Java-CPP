import java.util.Scanner;

 public class SilverB_MergeSort {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int length = input.nextInt();
         int[] array = new int[length];
         for (int i = 0; i < length; i++) {
             array[i] = input.nextInt();
         }

         mergeSort(array, 0, length - 1);
     }

     public static void mergeSort(int[] array, int left, int right) {
         if (left >= right) {
             return;
         }
         int mid = (left + right)/2;
         mergeSort(array, left, mid);
         mergeSort(array, mid+1, right);

         int i = left;
         int j = mid + 1;
         int k = left;
         int[] temp = new int[array.length];
         while (i <= mid && j <= right) {
             if (array[i] < array[j]) {
                 temp[k] = array[i];
                 i++;
             }
             else {
                 temp[k] = array[j];
                 j++;
             }
             k++;
         }
         for (int t = i; t <= mid; t++) {
             temp[k] = array[t];
             k++;
         }
         for (int t = j; t <= right; t++) {
             temp[k] = array[t];
             k++;
         }
         for (int t = left; t <= right; t++) {
             array[t] = temp[t];
         }

         for (int num = 0; num < array.length; num++) {
             System.out.print(array[num] + " ");
         }
         System.out.println();
     }
 }


