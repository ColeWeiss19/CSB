if (i < M - 1) {
    char next = regexp.charAt(i + 1);
    if (next == '?') {
        G.addEdge(lp, i + 1);   // skip over the character
        G.addEdge(i, i + 1);    // match it once
    }
}
