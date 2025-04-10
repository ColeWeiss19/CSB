import java.util.Scanner;

public class TheOldGame {
    public static String whoWins(int stones) {
        return (stones % 4 == 0) ? "Second" : "First";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int stones = sc.nextInt();
            System.out.println(whoWins(stones));
        }

        sc.close();
    }
}
