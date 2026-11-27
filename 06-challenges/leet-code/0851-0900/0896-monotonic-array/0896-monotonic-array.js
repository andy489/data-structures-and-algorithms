// https://leetcode.com/problems/monotonic-array/

var isMonotonic = function(nums) {
    let inc = false, dec = false;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i-1]) inc = true;
        if (nums[i] < nums[i-1]) dec = true;
        if (inc && dec) return false;
    }
    return true;
};
