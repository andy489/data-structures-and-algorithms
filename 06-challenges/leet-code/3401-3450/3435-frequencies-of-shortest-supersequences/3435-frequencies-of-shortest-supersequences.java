// https://leetcode.com/problems/frequencies-of-shortest-supersequences/
class Solution {
    public List<List<Integer>> supersequences(String[] words) {
        // Map characters to indices 0..m-1
        int[] charIndex = new int[26];
        Arrays.fill(charIndex, -1);
        int m = 0;
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (charIndex[c - 'a'] == -1) {
                    charIndex[c - 'a'] = m++;
                }
            }
        }

        // For each pair (i,j): edge[i] |= (1 << j) means i must come before j
        // pairs[i][j] = true if word "ij" exists (i != j)
        boolean[][] hasEdge = new boolean[m][m];
        int[] minCount = new int[m]; // min occurrences needed
        for (String w : words) {
            int a = charIndex[w.charAt(0) - 'a'];
            int b = charIndex[w.charAt(1) - 'a'];
            if (a == b) {
                minCount[a] = Math.max(minCount[a], 2);
            } else {
                hasEdge[a][b] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (minCount[i] == 0) {
                minCount[i] = 1;
            }
        }

        // We need to find topological orderings of these m chars.
        // For each pair (a,b) where hasEdge[a][b] and hasEdge[b][a], one of them will be
        // a "cycle-breaking" edge needing an extra char.
        // SCS length = sum(minCount) + number of cycle-breaking edges

        // Use bitmask DP to find minimum SCS length considering topological order
        // dp[mask] = minimum extra edges (back edges) for processing chars in `mask`
        // in some topological order

        int full = 1 << m;
        int[] dp = new int[full];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int mask = 0; mask < full; mask++) {
            if (dp[mask] == Integer.MAX_VALUE / 2) {
                continue;
            }
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    continue;
                }
                // Add node i next; count edges from already-placed nodes to i that go backwards
                int extra = 0;
                for (int j = 0; j < m; j++) {
                    if ((mask & (1 << j)) == 0) {
                        continue;
                    }
                    // j already placed before i; if hasEdge[i][j], then i->j is violated -> extra
                    if (hasEdge[i][j]) {
                        extra++;
                    }
                }
                int newMask = mask | (1 << i);
                if (dp[mask] + extra < dp[newMask]) {
                    dp[newMask] = dp[mask] + extra;
                }
            }
        }

        int minExtra = dp[full - 1];
        int baseLen = 0;
        for (int cnt : minCount) {
            baseLen += cnt;
        }
        int scsLen = baseLen + minExtra;

        // Now find all orderings that achieve minExtra, build frequency arrays
        // Backtrack through DP to find all valid orderings
        Set<List<Integer>> result = new HashSet<>();
        int[] freq = new int[26];
        for (int i = 0; i < 26; i++) {
            if (charIndex[i] != -1) {
                freq[i] = minCount[charIndex[i]];
            }
        }

        // We'll do a DFS to enumerate all optimal orderings and collect frequency arrays
        // For each ordering, the total frequency = base + extra counts from cycle edges
        // The frequency of char at position p in ordering gets +1 for each cycle edge
        // We need to find exact frequency array for each optimal ordering

        int[] order = new int[m];
        int[] extraCount = new int[m]; // how many extra counts each char needs in this ordering
        dfs(0, 0, dp, hasEdge, minCount, minExtra, m, order, extraCount, charIndex, result);

        return new ArrayList<>(result);
    }

    private void dfs(int pos, int mask, int[] dp, boolean[][] hasEdge, int[] minCount,
                     int minExtra, int m, int[] order, int[] extraCount,
                     int[] charIndex, Set<List<Integer>> result) {
        if (pos == m) {
            if (dp[mask] == minExtra) {
                // Build frequency array
                int[] freq = new int[26];
                for (int i = 0; i < 26; i++) {
                    if (charIndex[i] != -1) {
                        freq[i] = minCount[charIndex[i]] + extraCount[charIndex[i]];
                    }
                }
                List<Integer> freqList = new ArrayList<>();
                for (int f : freq) {
                    freqList.add(f);
                }
                result.add(freqList);
            }
            return;
        }
        for (int i = 0; i < m; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            int extra = 0;
            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) == 0) {
                    continue;
                }
                if (hasEdge[i][j]) {
                    extra++;
                }
            }
            int newMask = mask | (1 << i);
            if (dp[mask] + extra <= minExtra && dp[newMask] == dp[mask] + extra) {
                extraCount[i] += extra;
                order[pos] = i;
                dfs(pos + 1, newMask, dp, hasEdge, minCount, minExtra, m, order, extraCount, charIndex, result);
                extraCount[i] -= extra;
            }
        }
    }
}
