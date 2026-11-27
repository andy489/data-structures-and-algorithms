// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

var findLengthOfLCIS = function(nums) {
    let best = 1, curr = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            curr++;
            best = Math.max(best, curr);
        } else {
            curr = 1;
        }
    }
    return best;
};
