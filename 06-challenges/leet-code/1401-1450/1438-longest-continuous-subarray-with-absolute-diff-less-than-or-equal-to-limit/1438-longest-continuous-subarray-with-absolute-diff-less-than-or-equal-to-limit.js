// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

var longestSubarray = function(nums, limit) {
    const maxDq = [], minDq = [];
    let left = 0, ans = 0;
    for (let r = 0; r < nums.length; r++) {
        while (maxDq.length && nums[maxDq[maxDq.length-1]] <= nums[r]) maxDq.pop();
        while (minDq.length && nums[minDq[minDq.length-1]] >= nums[r]) minDq.pop();
        maxDq.push(r); minDq.push(r);
        while (nums[maxDq[0]] - nums[minDq[0]] > limit) {
            left++;
            if (maxDq[0] < left) maxDq.shift();
            if (minDq[0] < left) minDq.shift();
        }
        ans = Math.max(ans, r - left + 1);
    }
    return ans;
};
