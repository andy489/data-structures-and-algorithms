// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

var numSubarrayBoundedMax = function(nums, left, right) {
    function count(bound) {
        let result = 0, curr = 0;
        for (const num of nums) {
            curr = num <= bound ? curr + 1 : 0;
            result += curr;
        }
        return result;
    }
    return count(right) - count(left - 1);
};
