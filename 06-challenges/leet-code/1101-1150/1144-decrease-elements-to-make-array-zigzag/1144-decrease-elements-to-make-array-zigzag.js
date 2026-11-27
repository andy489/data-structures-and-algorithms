// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/

var movesToMakeZigzag = function(nums) {
    const n = nums.length;
    const cost = [0, 0];
    for (let p = 0; p < 2; p++) {
        for (let i = p; i < n; i += 2) {
            let minNb = Infinity;
            if (i > 0) { minNb = Math.min(minNb, nums[i - 1]); }
            if (i < n - 1) { minNb = Math.min(minNb, nums[i + 1]); }
            if (nums[i] >= minNb) {
                cost[p] += nums[i] - minNb + 1;
            }
        }
    }
    return Math.min(cost[0], cost[1]);
};
