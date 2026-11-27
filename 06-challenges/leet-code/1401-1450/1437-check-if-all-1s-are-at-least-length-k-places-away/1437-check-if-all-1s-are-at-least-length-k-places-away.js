// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

var kLengthApart = function(nums, k) {
    let prev = -1;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 1) {
            if (prev !== -1 && i - prev - 1 < k) return false;
            prev = i;
        }
    }
    return true;
};
