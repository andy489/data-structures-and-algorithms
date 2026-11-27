// https://leetcode.com/problems/longest-arithmetic-sequence-after-changing-at-most-one-element/

/**
 * @param {number[]} nums
 * @return {number}
 */
var longestArithSeqAfterChange = function(nums) {
    const n = nums.length;
    const dp0 = new Array(n).fill(1);
    const dp1 = new Array(n).fill(1);
    dp0[1] = dp1[1] = 2;
    let ans = 2;
    for (let i = 2; i < n; i++) {
        const d1 = nums[i] - nums[i - 1];
        const d2 = nums[i - 1] - nums[i - 2];
        if (d1 === d2) {
            dp0[i] = dp0[i - 1] + 1;
            dp1[i] = dp1[i - 1] + 1;
        } else {
            dp0[i] = 2;
            dp1[i] = dp0[i - 1] + 1;
            const d3 = nums[i] - nums[i - 2];
            if (d3 % 2 === 0 && d3 / 2 === d2) {
                dp1[i] = Math.max(dp1[i], dp0[i - 2] + 2);
            }
        }
        ans = Math.max(ans, dp0[i], dp1[i]);
    }
    return ans;
};
