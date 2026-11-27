// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

// Two pointers — O(n) time, O(1) space
var twoSum = function(numbers, target) {
    let lo = 0, hi = numbers.length - 1;
    while (lo < hi) {
        const s = numbers[lo] + numbers[hi];
        if (s === target) return [lo + 1, hi + 1];
        if (s < target) lo++;
        else hi--;
    }
    return [-1, -1];
};
