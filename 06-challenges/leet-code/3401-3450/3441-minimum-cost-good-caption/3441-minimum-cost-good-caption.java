// https://leetcode.com/problems/minimum-cost-good-caption/
class Solution {
    public String minCostGoodCaption(String caption) {
        int n = caption.length();
        if (n < 3) {
            return "";
        }

        // dp[i] = min cost to make caption[0..i-1] a good caption
        // choice[i][g] = char chosen for the last group of size g ending at i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        // For reconstruction: store (groupSize, charChosen) for each position
        int[] bestGroupSize = new int[n + 1];
        char[] bestChar = new char[n + 1];

        // Precompute prefix sums for each character
        int[][] prefix = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                prefix[c][i + 1] = prefix[c][i];
            }
            prefix[caption.charAt(i) - 'a'][i + 1]++;
        }

        for (int i = 3; i <= n; i++) {
            // Try group sizes 3, 4, 5
            for (int g = 3; g <= 5 && g <= i; g++) {
                int l = i - g; // group is caption[l..i-1]
                if (dp[l] == Integer.MAX_VALUE / 2) {
                    continue;
                }
                // Find best char for this group (minimum cost = sum |caption[j] - c|)
                // Equivalent to: find c minimizing sum of distances to chars in [l, i-1]
                // This is minimized at the median
                int bestCost = Integer.MAX_VALUE;
                char bestC = 'a';
                for (int c = 0; c < 26; c++) {
                    int cost = 0;
                    for (int j = l; j < i; j++) {
                        cost += Math.abs((caption.charAt(j) - 'a') - c);
                    }
                    if (cost < bestCost || (cost == bestCost && (char)('a' + c) < bestC)) {
                        bestCost = cost;
                        bestC = (char)('a' + c);
                    }
                }
                int total = dp[l] + bestCost;
                if (total < dp[i] || (total == dp[i] && bestC < bestChar[i])) {
                    dp[i] = total;
                    bestGroupSize[i] = g;
                    bestChar[i] = bestC;
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE / 2) {
            return "";
        }

        // Reconstruct
        char[] result = new char[n];
        int pos = n;
        while (pos > 0) {
            int g = bestGroupSize[pos];
            char c = bestChar[pos];
            for (int j = pos - g; j < pos; j++) {
                result[j] = c;
            }
            pos -= g;
        }
        return new String(result);
    }
}
