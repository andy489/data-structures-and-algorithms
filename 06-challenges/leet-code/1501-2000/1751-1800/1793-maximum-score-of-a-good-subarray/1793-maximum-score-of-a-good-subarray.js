// https://leetcode.com/problems/maximum-score-of-a-good-subarray/

var maximumScore = function(nums, k) {
    const n = nums.length;
    let i = k, j = k;
    let minVal = nums[k];
    let ans = nums[k];
    while (i > 0 || j < n - 1) {
        if (i === 0) {
            j++;
        } else if (j === n - 1) {
            i--;
        } else if (nums[i - 1] >= nums[j + 1]) {
            i--;
        } else {
            j++;
        }
        minVal = Math.min(minVal, nums[i], nums[j]);
        ans = Math.max(ans, minVal * (j - i + 1));
    }
    return ans;
};
