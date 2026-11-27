// https://leetcode.com/problems/maximize-win-from-two-segments/

// Solution: Sliding Window + DP — O(n) time, O(n) space
var maximizeWin = function(prizePositions, k) {
    const n = prizePositions.length;
    const dp = new Array(n + 1).fill(0);
    let ans = 0;
    for (let l = 0, r = 0; r < n; r++) {
        while (prizePositions[r] - prizePositions[l] > k) {
            l++;
        }
        const windowSize = r - l + 1;
        dp[r + 1] = Math.max(dp[r], windowSize);
        ans = Math.max(ans, dp[l] + windowSize);
    }
    return ans;
};
