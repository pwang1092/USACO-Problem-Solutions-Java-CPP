import java.util.Scanner;

public class BronzeB_MNotes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfNotes = input.nextInt();
        int numberOfQuestions = input.nextInt();

        //create array of String Lengths
        int[] noteLengths = new int[numberOfNotes];
        for (int i = 0; i < numberOfNotes; i++) {
            noteLengths[i] = input.nextInt();
        }

        //array of the questions' index, index being the time of the note.
        int[] questionValue = new int[numberOfQuestions];
        for (int i = 0; i< numberOfQuestions; i++) {
            questionValue[i] = input.nextInt();
        }

        int[] startPosOfNote = new int[numberOfNotes];
        startPosOfNote[0] = 0;
        for (int i = 1; i < numberOfNotes; i++) {
            startPosOfNote[i] = startPosOfNote[i-1] + noteLengths[i-1];
        }

        for (int i = 0; i < numberOfQuestions; i++) {
            int k = 1;
            int j = 0;
            while (j < startPosOfNote.length) {
                if (startPosOfNote[j] > questionValue[i]) {
                    break;
                }
                k = j + 1;
                j++;
            }
            System.out.println(k);
        }
    }
}
