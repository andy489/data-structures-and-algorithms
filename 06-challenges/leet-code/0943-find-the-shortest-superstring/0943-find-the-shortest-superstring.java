// https://leetcode.com/problems/find-the-shortest-superstring/

// Solution: Bitmask DP — O(2^n * n²) time, O(2^n * n) space
class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int maxOv = Math.min(words[i].length(), words[j].length());
                    for (int ov = maxOv; ov > 0; ov--) {
                        if (words[i].endsWith(words[j].substring(0, ov))) {
                            overlap[i][j] = ov;
                            break;
                        }
                    }
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = words[i].length();
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int last = 0; last < n; last++) {
                if ((mask & (1 << last)) == 0 || dp[mask][last] == Integer.MAX_VALUE / 2) {
                    continue;
                }
                for (int next = 0; next < n; next++) {
                    if ((mask & (1 << next)) != 0) {
                        continue;
                    }
                    int newMask = mask | (1 << next);
                    int newLen = dp[mask][last] + words[next].length() - overlap[last][next];
                    if (newLen < dp[newMask][next]) {
                        dp[newMask][next] = newLen;
                        parent[newMask][next] = last;
                    }
                }
            }
        }
        int fullMask = (1 << n) - 1, last = 0;
        for (int i = 1; i < n; i++) {
            if (dp[fullMask][i] < dp[fullMask][last]) {
                last = i;
            }
        }
        int[] order = new int[n];
        int mask = fullMask;
        for (int i = n - 1; i >= 0; i--) {
            order[i] = last;
            int prev = parent[mask][last];
            mask ^= (1 << last);
            last = prev;
        }
        StringBuilder sb = new StringBuilder(words[order[0]]);
        for (int i = 1; i < n; i++) {
            sb.append(words[order[i]].substring(overlap[order[i - 1]][order[i]]));
        }
        return sb.toString();
    }
}
