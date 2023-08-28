import java.util.*;
import java.lang.*;

public class BronzeB_Tictactoe {
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        String line;
        for (int i = 0; i < 3; i++) {
            line = input.next();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        char[] alphabet = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char letter;
        int indivcounter = 0;
        boolean indiv = false;
        /** individual win */
        for (int i = 0; i < 26; i++) {
            letter = alphabet[i];
            // rows and columns
            for (int j = 0; j < 3; j++) {
                if (board[j][0] == letter && board[j][1] == letter && board[j][2] == letter) {
                    indivcounter++;
                    indiv = true;
                    break; // break if win found
                }
                else if(board[0][j] == letter && board[1][j] == letter && board[2][j] == letter) {
                    indivcounter++;
                    break; // break if win found
                }
            }
            // diagonals
            if (!indiv && board[0][0] == letter && board[1][1] == letter && board[2][2] == letter) {
                indivcounter++;
            }
            else if (!indiv && board[2][0] == letter && board[1][1] == letter && board[0][2] == letter) {
                indivcounter++;
            }
        }
        /** team win */
        char letter1;
        char letter2;
        boolean team = false;
        int counter = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i+1; j < 26; j++) {
                letter1 = alphabet[i];
                letter2 = alphabet[j];
                // rows and columns
                for (int k = 0; k < 3; k++) {
                    if (!isIndiv(letter1, board, k, 0, k, 1, k, 2) && !isIndiv(letter2, board, k, 0, k, 1, k, 2)
                            && isTeam(letter1, letter2, board, k, 0, k, 1, k, 2)) {
                          counter++;
                          team = true;
                          break; // break if win found
                      }
                      else if (!isIndiv(letter1, board, 0, k, 1, k, 2, k) && !isIndiv(letter2, board, 0, k, 1, k, 2, k)
                            && isTeam(letter1, letter2, board, 0, k, 1, k, 2, k)) {
                          counter++;
                          team = true;
                          break; // break if win found
                      }
                  }
                 // diagonals
                if (!team && !isIndiv(letter1, board, 0, 0, 1, 1, 2, 2) && !isIndiv(letter2, board, 0, 0, 1, 1, 2, 2)
                        && isTeam(letter1, letter2, board, 0, 0, 1, 1, 2, 2)) {
                      counter++;
                }
                if (!team && !isIndiv(letter1, board, 2, 0, 1, 1, 0, 2) && !isIndiv(letter2, board, 2, 0, 1, 1, 0, 2)
                        && isTeam(letter1, letter2, board, 2, 0, 1, 1, 0, 2)) {
                    counter++;
                }
            }
        }

        System.out.println(indivcounter);
        System.out.print(counter);
    }

    public static boolean isIndiv(char letter, char[][] board, int x1, int y1, int x2, int y2, int x3, int y3) {
        if ( board[x1][y1] != letter ) {
            return false;
        }
        if ( board[x2][y2] != letter ) {
            return false;
        }
        if ( board[x3][y3] != letter ) {
            return false;
        }
        return true;
    }

    public static boolean isTeam(char one, char two, char[][] board, int x1, int y1, int x2, int y2, int x3, int y3) {
        if ( board[x1][y1] != one && board[x1][y1] != two) {
            return false;
        }
        if ( board[x2][y2] != one && board[x2][y2] != two) {
            return false;
        }
        if ( board[x3][y3] != one && board[x3][y3] != two) {
            return false;
        }
        return true;
    }
}



