// https://leetcode.com/problems/house-robber-ii/

// Solution: Two Linear DP Passes — O(n) time, O(1) space
var rob = function(nums) {
    const n = nums.length;
    if (n === 1) return nums[0];

    function robLinear(lo, hi) {
        let prev2 = 0, prev1 = 0;
        for (let i = lo; i <= hi; i++) {
            const curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    return Math.max(robLinear(0, n - 2), robLinear(1, n - 1));
};
