private Digraph buildEpsilonTransitionDigraph(String regexp) {
    int M = regexp.length();
    Digraph G = new Digraph(M + 1);
    Stack<Integer> ops = new Stack<>();

    for (int i = 0; i < M; i++) {
        int lp = i;

        if (regexp.charAt(i) == '(' || regexp.charAt(i) == '|')
            ops.push(i);
        else if (regexp.charAt(i) == ')') {
            int or = ops.pop();

            if (regexp.charAt(or) == '|') {
                lp = ops.pop();
                G.addEdge(lp, or + 1);
                G.addEdge(or, i);
            } else {
                lp = or;
            }
        }

        if (i < M - 1) {
            char next = regexp.charAt(i + 1);
            if (next == '*') {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            } else if (next == '+') {
                G.addEdge(i + 1, lp); // force at least one match
            }
        }

        if (regexp.charAt(i) == '(' || regexp.charAt(i) == '*' || 
            regexp.charAt(i) == ')' || regexp.charAt(i) == '+')
            G.addEdge(i, i + 1);
    }

    return G;
}
