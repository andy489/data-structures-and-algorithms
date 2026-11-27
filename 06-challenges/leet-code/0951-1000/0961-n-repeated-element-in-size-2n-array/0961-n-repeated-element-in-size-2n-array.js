// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

var repeatedNTimes = function(nums) {
    const seen = new Set();
    for (const x of nums) {
        if (seen.has(x)) return x;
        seen.add(x);
    }
};
