// https://leetcode.com/problems/largest-number/

// Solution: Custom Comparator Sort — O(n log n * k) time, O(n) space
var largestNumber = function(nums) {
    const strs = nums.map(String);
    strs.sort((a, b) => (b + a) > (a + b) ? 1 : -1);
    if (strs[0] === '0') return '0';
    return strs.join('');
};
