// https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/

var maxSum = function(nums) {
    const positives = new Set();
    for (const x of nums) {
        if (x > 0) positives.add(x);
    }
    if (positives.size > 0) {
        let sum = 0;
        for (const x of positives) sum += x;
        return sum;
    }
    return Math.max(...nums);
};
