// https://leetcode.com/problems/frequency-of-the-most-frequent-element/

var maxFrequency = function(nums, k) {
    nums.sort((a, b) => a - b);
    let l = 0, windowSum = 0, ans = 1;
    for (let r = 0; r < nums.length; r++) {
        windowSum += nums[r];
        while (nums[r] * (r - l + 1) - windowSum > k) {
            windowSum -= nums[l];
            l++;
        }
        ans = Math.max(ans, r - l + 1);
    }
    return ans;
};
