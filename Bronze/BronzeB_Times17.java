import java.util.*;
import java.lang.*;

public class BronzeB_Times17{
    public static void main(String[] args) {
        // receive input
        Scanner input = new Scanner(System.in);
        String originalNum = input.next();
        String num = originalNum + "0000";
        originalNum = "0000" + originalNum;

        char carryBit = '0';
        String ans = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            if (carryBit == '1' && (originalNum.charAt(i) == '1' && num.charAt(i) == '1')) {
                ans = "1" + ans;
            }
            else if (carryBit == '1' && (originalNum.charAt(i) == '1' || num.charAt(i) == '1')) {
                ans = "0" + ans;
            }
            else if (carryBit == '1' && (originalNum.charAt(i) == '0' && num.charAt(i) == '0')) {
                ans = "1" + ans;
                carryBit = '0';
            }
            else if (carryBit == '0' && (originalNum.charAt(i) == '1' && num.charAt(i) == '1')) {
                ans = "0" + ans;
                carryBit = '1';
            }
            else if (carryBit == '0' && (originalNum.charAt(i) == '1' || num.charAt(i) == '1')) {
                ans = "1" + ans;
            }
            else if (carryBit == '0' && (originalNum.charAt(i) == '0' && num.charAt(i) == '0')){
                ans = "0" + ans;
            }
        }
        System.out.print(ans);
    }
}






