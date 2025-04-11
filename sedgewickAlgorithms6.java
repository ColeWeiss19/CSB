else if (regexp.charAt(i) == ')') {
    Queue<Integer> ors = new LinkedList<>();
    while (regexp.charAt(ops.peek()) == '|')
        ors.add(ops.pop());
    int lp = ops.pop(); // This should be '('

    for (int or : ors) {
        G.addEdge(lp, or + 1);
        G.addEdge(or, i);
    }
}
