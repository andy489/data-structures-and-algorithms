// https://leetcode.com/problems/max-consecutive-ones-iii/

var longestOnes = function(nums, k) {
    let left = 0, zeros = 0, ans = 0;
    for (let right = 0; right < nums.length; right++) {
        if (nums[right] === 0) zeros++;
        while (zeros > k) {
            if (nums[left++] === 0) zeros--;
        }
        ans = Math.max(ans, right - left + 1);
    }
    return ans;
};
