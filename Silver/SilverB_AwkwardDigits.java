import java.util.*;

public class SilverB_AwkwardDigits {
    public static void main(String[] args) {
        /** 1. scan the temperature productions */
        Scanner input = new Scanner(System.in);
        String binary = input.next();
        String ternary = input.next();
        int[] binaryArr = new int[binary.length()];
        int[] binaryTemp = new int[binary.length()];
        int[] ternaryArr = new int[ternary.length()];
        int[] ternaryTemp = new int[ternary.length()];

        for (int i = 0; i < binary.length(); i++) {
            binaryArr[i] = Integer.parseInt(binary.substring(i, i+1));
            binaryTemp[i] = binaryArr[i];
        }
        for (int i = 0; i < ternary.length(); i++) {
            ternaryArr[i] = Integer.parseInt(ternary.substring(i, i+1));
            ternaryTemp[i] = ternaryArr[i];
        }


        int n1;
        int n2;
        for (int i = 0; i < binaryArr.length; i++) {
            if (binaryArr[i] == 0) {
                binaryTemp[i] = 1;
            }
            else {
                binaryTemp[i] = 0;
            }
            n1 = binaryToDecimal(binaryTemp);

            for (int j = 0; j < ternaryArr.length; j++) {
                /** after switching temp to other digits and testing,
                 * don't forget to reassign the original value afterwards
                 */
                if (ternaryArr[j] == 0) {
                    ternaryTemp[j] = 1;
                    n2 = ternaryToDecimal(ternaryTemp);
                    if (n1 == n2) {
                        System.out.print(n1);
                        System.exit(0);
                    }
                    ternaryTemp[j] = 2;
                    n2 = ternaryToDecimal(ternaryTemp);
                    if (n1 == n2) {
                        System.out.print(n1);
                        System.exit(0);
                    }
                    ternaryTemp[j] = 0;
                }
                else if (ternaryArr[j] == 1) {
                    ternaryTemp[j] = 0;
                    n2 = ternaryToDecimal(ternaryTemp);
                    if (n1 == n2) {
                        System.out.print(n1);
                        System.exit(0);
                    }
                    ternaryTemp[j] = 2;
                    n2 = ternaryToDecimal(ternaryTemp);
                    if (n1 == n2) {
                        System.out.print(n1);
                        System.exit(0);
                    }
                    ternaryTemp[j] = 1;
                }
                else {
                    ternaryTemp[j] = 0;
                    n2 = ternaryToDecimal(ternaryTemp);
                    if (n1 == n2) {
                        System.out.print(n1);
                        System.exit(0);
                    }
                    ternaryTemp[j] = 1;
                    n2 = ternaryToDecimal(ternaryTemp);
                    if (n1 == n2) {
                        System.out.print(n1);
                        System.exit(0);
                    }
                    ternaryTemp[j] = 2;
                }
            }
            binaryTemp[i] = binaryArr[i];
        }
        System.out.print("Failed");
    }

    public static int binaryToDecimal(int[] binary) {
        int ans = 0;
        int power = 0;
        for (int i = binary.length - 1; i >= 0; i--) {
            ans += binary[i] * Math.pow(2, power);
            power++;
        }
        return ans;
    }

    public static int ternaryToDecimal(int[] ternary) {
        int ans = 0;
        int power = 0;
        for (int i = ternary.length-1; i>=0; i--) {
            ans += ternary[i] * Math.pow(3, power);
            power++;
        }
        return ans;
    }
}

/**
 for (int i = 0; i < binary.length(); i++) {
 System.out.print(binaryArr[i]);
 }
 System.out.println();
 for (int i = 0; i < ternary.length(); i++) {
 System.out.println(ternaryArr[i]);
 }
 */