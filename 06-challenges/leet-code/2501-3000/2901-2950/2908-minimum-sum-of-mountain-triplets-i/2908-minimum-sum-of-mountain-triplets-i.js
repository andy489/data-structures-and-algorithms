// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/

var minimumSum = function(nums) {
    const n = nums.length;
    let minSum = Infinity;
    for (let i = 0; i < n - 2; i++) {
        for (let j = i + 1; j < n - 1; j++) {
            for (let k = j + 1; k < n; k++) {
                if (nums[i] < nums[j] && nums[k] < nums[j]) {
                    minSum = Math.min(minSum, nums[i] + nums[j] + nums[k]);
                }
            }
        }
    }
    return minSum === Infinity ? -1 : minSum;
};
