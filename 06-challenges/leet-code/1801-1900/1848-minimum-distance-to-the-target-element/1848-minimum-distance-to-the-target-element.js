// https://leetcode.com/problems/minimum-distance-to-the-target-element/

var getMinDistance = function(nums, target, start) {
    let ans = Infinity;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === target) {
            ans = Math.min(ans, Math.abs(i - start));
        }
    }
    return ans;
};
