// https://leetcode.com/problems/count-the-number-of-fair-pairs/

// Solution: Sort + Two Pointers — O(n log n) time, O(1) space
var countFairPairs = function(nums, lower, upper) {
    nums.sort((a, b) => a - b);

    function countLess(target) {
        let count = 0;
        let l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                count += r - l;
                l++;
            } else {
                r--;
            }
        }
        return count;
    }

    return countLess(upper + 1) - countLess(lower);
};
