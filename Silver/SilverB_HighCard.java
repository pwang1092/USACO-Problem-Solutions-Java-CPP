import java.util.Scanner;
import java.util.*;

 public class SilverB_HighCard {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int numberOfCardsInEachHand = input.nextInt();

         //get elsie's hand of cards
         int[] elsieCards = new int[numberOfCardsInEachHand];
         int[] allCards = new int[2*numberOfCardsInEachHand];
         for (int i = 0; i < numberOfCardsInEachHand; i++) {
             elsieCards[i] = input.nextInt();
             allCards[elsieCards[i]-1] = 1;
         }
         Arrays.sort(elsieCards);

         //get bessie's hand of cards
         int[] bessieCards = new int[numberOfCardsInEachHand];
         int j = 0;
         for (int i = 0; i < 2*numberOfCardsInEachHand; i++) {
             if (allCards[i] == 0) {
                 bessieCards[j] = i+1;
                 j++;
             }
         }

         Arrays.sort(bessieCards);

         int elsieIndex = 0;
         int bessieIndex = 0;
         int beat = 0;
         for (int i = 0; i < numberOfCardsInEachHand; i++) {
             if (bessieCards[bessieIndex] > elsieCards[elsieIndex]) {
                 beat++;
                 elsieIndex++;

             }
             bessieIndex++;
         }

         System.out.print(beat);
     }
 }


/**
 for (int m = 0; m < numberOfCardsInEachHand; m++) {
 System.out.println(elsieCards[m]);
 }

 for (int m = 0; m < numberOfCardsInEachHand; m++) {
 System.out.println(bessieCards[m]);
 }
 */