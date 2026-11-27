// https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/

// Solution: Sliding Window + DP — O(n) time, O(n) space
class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        int[] dp = new int[n + 1];
        // diff[i] = 1 if boxes[i] and boxes[i-1] go to different ports
        int[] diff = new int[n + 1];
        for (int i = 1; i < n; i++) {
            diff[i] = (boxes[i][0] != boxes[i - 1][0]) ? 1 : 0;
        }
        // trips[i] = number of different-port changes in window [j+1..i]
        // Use two pointers: l is the left boundary of the window
        int l = 0;
        long weight = 0;
        int trips = 0; // port changes in window [l..r]
        for (int r = 0; r < n; r++) {
            weight += boxes[r][1];
            if (r > 0) {
                trips += diff[r];
            }
            while (r - l + 1 > maxBoxes || weight > maxWeight) {
                weight -= boxes[l][1];
                if (l + 1 <= r) {
                    trips -= diff[l + 1];
                }
                l++;
            }
            // dp[r+1] = dp[l] + trips + 2 (go to ports and come back)
            // But we want the minimum, also compare with not bringing box r alone
            dp[r + 1] = dp[l] + trips + 2;
            // Optimize: since dp is non-decreasing, also check dp[r] + 1 when same port
            if (r > 0 && boxes[r][0] == boxes[r - 1][0]) {
                dp[r + 1] = Math.min(dp[r + 1], dp[r]);
            }
        }
        return dp[n];
    }
}
