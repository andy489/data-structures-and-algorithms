// https://leetcode.com/problems/remove-boxes/
// Solution: 3D interval DP — O(n^4) time, O(n^3) space
var removeBoxes = function(boxes) {
    const n = boxes.length;
    const memo = Array.from({length: n}, () =>
        Array.from({length: n}, () => new Array(n).fill(0))
    );
    function dp(l, r, k) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r][k] !== 0) {
            return memo[l][r][k];
        }
        let result = (k + 1) * (k + 1) + dp(l + 1, r, 0);
        for (let m = l + 1; m <= r; m++) {
            if (boxes[m] === boxes[l]) {
                result = Math.max(result, dp(l + 1, m - 1, 0) + dp(m, r, k + 1));
            }
        }
        memo[l][r][k] = result;
        return result;
    }
    return dp(0, n - 1, 0);
};
