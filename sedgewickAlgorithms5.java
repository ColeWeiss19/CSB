public class GREP {
    public static void main(String[] args) {
        String regexp = "(" + args[0] + ")";
        NFA nfa = new NFA(regexp);

        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            if (nfa.recognizes(line))
                StdOut.println(line);
        }
    }
}
