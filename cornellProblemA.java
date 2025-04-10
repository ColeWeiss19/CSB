import java.util.Scanner;

public class AscendingDigitSum {
    public static boolean isAscending(int number) {
        String numStr = Integer.toString(number);
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) <= numStr.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        for (int i = start; i <= end; i++) {
            if (isAscending(i)) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}
