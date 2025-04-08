public class BruteForceSearchWithCount {

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int compares = 0;

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                compares++;
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                System.out.println("Pattern found at index " + i);
                System.out.println("Total character comparisons: " + compares);
                return i;
            }
        }

        System.out.println("Pattern not found.");
        System.out.println("Total character comparisons: " + compares);
        return -1;
    }

    public static void main(String[] args) {
        String text = "aaaaaaab";
        String pattern = "aaab";
        search(pattern, text);
    }
}
