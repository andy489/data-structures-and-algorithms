// https://leetcode.com/problems/triangle/

// Solution: Bottom-Up DP In-Place — O(n^2) time, O(1) extra space
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int best = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + best);
            }
        }
        return triangle.get(0).get(0);
    }
}

// Solution 2: Bottom-Up DP with Auxiliary Array — O(n^2) time, O(n) space
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
