// https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/

// Solution: DP with boolean set — O(m * n * maxSum) time, O(maxSum) space
var minimizeTheDifference = function(mat, target) {
    let dp = new Set([0]);
    for (const row of mat) {
        const next = new Set();
        for (const s of dp) {
            for (const v of row) {
                next.add(s + v);
            }
        }
        dp = next;
    }
    let ans = Infinity;
    for (const s of dp) {
        ans = Math.min(ans, Math.abs(s - target));
    }
    return ans;
};
