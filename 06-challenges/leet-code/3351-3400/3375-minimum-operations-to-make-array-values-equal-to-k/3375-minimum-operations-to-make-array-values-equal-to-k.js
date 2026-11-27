// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/

var minOperations = function(nums, k) {
    const distinct = new Set();
    for (const x of nums) {
        if (x < k) {
            return -1;
        }
        if (x > k) {
            distinct.add(x);
        }
    }
    return distinct.size;
};
