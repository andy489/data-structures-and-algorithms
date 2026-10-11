// https://leetcode.com/problems/regular-expression-matching/
// Dynamic Programming
// Time: O(n*m), Space: O(n*m)

class Solution {
    private String s, p;
    private int n, m;
    private Boolean[][] cache;

    private boolean dfs(int i, int j) {
        if (i <= n && j < m && cache[i][j] != null) { // check if it is already in the cache
            return cache[i][j];
        }
        
        if (j >= m) { // if we read the pattern string
            return i >= n; // check if we also read the string for matching
        }
        // index i could be technically out of bounds here (that's why cache rows are n+1)
        boolean match = i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        // * has the highest precedence (we handle * first)
        if (j + 1 < m && p.charAt(j + 1) == '*') {
            return cache[i][j] = dfs(i, j + 2) // don't use *
                    || (match && dfs(i + 1, j)); // use *
        }
        
        if (match) { // simple match of one character
            return cache[i][j] = dfs(i + 1, j + 1);
        }
        
        return cache[i][j] = false;

    }

    public boolean isMatch(String s, String p) { // Top-Down Memoization
        this.s = s;
        this.p = p;

        this.n = s.length();
        this.m = p.length();

        this.cache = new Boolean[n + 1][m];
        
        return dfs(0, 0);
    }
}