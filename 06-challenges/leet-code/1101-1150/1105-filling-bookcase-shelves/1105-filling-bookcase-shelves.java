// https://leetcode.com/problems/filling-bookcase-shelves/

// Solution: Dynamic Programming — O(n²) time, O(n) space
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int width = 0;
            int maxH = 0;
            for (int j = i; j >= 1; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) {
                    break;
                }
                maxH = Math.max(maxH, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + maxH);
            }
        }
        return dp[n];
    }
}
