// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
var countSubarrays = function(nums, k) {
    const maxVal = Math.max(...nums);
    let ans = 0;
    let cnt = 0;
    let left = 0;
    for (let right = 0; right < nums.length; right++) {
        if (nums[right] === maxVal) {
            cnt++;
        }
        while (cnt >= k) {
            if (nums[left] === maxVal) {
                cnt--;
            }
            left++;
        }
        ans += left;
    }
    return ans;
};
