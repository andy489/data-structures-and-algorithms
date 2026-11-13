// https://leetcode.com/problems/wildcard-matching/

// Solution: 2D DP — O(m·n) time, O(m·n) space
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == s.charAt(i - 1) || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}

// Solution3: NFA simulation — O(m·n) time, O(n) space
class Solution3 {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        // cur holds the set of NFA states (pattern positions) reachable before reading s[i]
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        epsilonClose(cur, p, n);

        for (int i = 0; i < s.length(); i++) {
            Set<Integer> next = new HashSet<>();
            for (int state : cur) {
                if (state < n) {
                    char pc = p.charAt(state);
                    if (pc == s.charAt(i) || pc == '?') {
                        next.add(state + 1);  // consume char, advance
                    } else if (pc == '*') {
                        next.add(state);      // star consumes this char, stays (loop)
                        next.add(state + 1);  // star matches empty, advance
                    }
                }
            }
            epsilonClose(next, p, n);
            cur = next;
        }
        return cur.contains(n);
    }

    // Expand all states reachable by consuming zero or more '*' transitions
    private void epsilonClose(Set<Integer> states, String p, int n) {
        Queue<Integer> queue = new ArrayDeque<>(states);
        while (!queue.isEmpty()) {
            int state = queue.poll();
            if (state < n && p.charAt(state) == '*') {
                // '*' can match empty: advance past it
                if (states.add(state + 1)) {
                    queue.add(state + 1);
                }
                // '*' can loop: stay at same state (already in set, no need to re-add)
            }
        }
    }
}
class Solution2 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int i = 0, j = 0, starJ = -1, matchI = 0;
        while (i < m) {
            if (j < n && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                starJ = j;
                matchI = i;
                j++;
            } else if (starJ != -1) {
                j = starJ + 1;
                matchI++;
                i = matchI;
            } else {
                return false;
            }
        }
        while (j < n && p.charAt(j) == '*') {
            j++;
        }
        return j == n;
    }
}
