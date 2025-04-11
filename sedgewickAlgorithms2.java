if (i < txt.length()) {
    for (int v : pc) {
        if (v == M) continue;
        char c = re[v];
        if (c == txt.charAt(i) || c == '.') 
            match.add(v + 1);
    }
}
