// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

var minDifference = function(nums) {
    const n = nums.length;
    if (n <= 4) return 0;
    nums.sort((a, b) => a - b);
    let ans = Infinity;
    for (let i = 0; i <= 3; i++) {
        ans = Math.min(ans, nums[n - 1 - (3 - i)] - nums[i]);
    }
    return ans;
};
