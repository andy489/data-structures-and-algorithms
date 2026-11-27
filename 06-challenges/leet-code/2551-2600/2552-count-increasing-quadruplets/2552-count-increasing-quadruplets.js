// https://leetcode.com/problems/count-increasing-quadruplets/

// Solution: O(n²) DP — count valid (i,k,j) triples then find l positions
var countQuadruplets = function(nums) {
    const n = nums.length;
    let ans = 0n;
    const dp = new Array(n).fill(0n);
    for (let k = 0; k < n; k++) {
        let cntLess = 0n;
        for (let i = 0; i < k; i++) {
            if (nums[i] < nums[k]) {
                cntLess++;
            }
        }
        for (let j = k + 1; j < n; j++) {
            if (nums[j] > nums[k]) {
                ans += dp[j];
            }
        }
        for (let j = k + 1; j < n; j++) {
            if (nums[j] > nums[k]) {
                dp[j] += cntLess;
            }
        }
    }
    return Number(ans);
};
