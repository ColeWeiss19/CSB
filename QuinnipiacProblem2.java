import java.util.Scanner;

public class SimpleHash {
    public static int charValue(char c) {
        if (Character.isUpperCase(c)) return c - 'A' + 1;
        else return -(c - 'a' + 1);
    }

    public static String computeHash(String s) {
        long hash = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int sum = charValue(s.charAt(i)) + charValue(s.charAt(i + 1));
            hash *= sum;
        }
        hash = Math.abs(hash);
        String result = String.format("%06d", hash % 1000000);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        while (cases-- > 0) {
            String input = sc.nextLine();
            System.out.println(computeHash(input));
        }
        sc.close();
    }
}
