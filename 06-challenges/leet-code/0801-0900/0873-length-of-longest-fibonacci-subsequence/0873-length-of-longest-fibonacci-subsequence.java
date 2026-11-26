// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

// Solution: DP with HashSet — O(n^2) time, O(n^2) space
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                int diff = arr[i] - arr[j];
                if (diff < arr[j] && idx.containsKey(diff)) {
                    int k = idx.get(diff);
                    dp[j][i] = dp[k][j] + 1;
                    ans = Math.max(ans, dp[j][i] + 2);
                }
            }
        }
        return ans;
    }
}
