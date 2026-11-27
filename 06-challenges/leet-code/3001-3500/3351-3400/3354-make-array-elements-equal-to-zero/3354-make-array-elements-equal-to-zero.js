// https://leetcode.com/problems/make-array-elements-equal-to-zero/

// Solution: Prefix Sum Balance Check — O(n) time, O(1) space
var countValidSelections = function(nums) {
    const total = nums.reduce((a, b) => a + b, 0);
    let ans = 0;
    let leftSum = 0;
    for (const x of nums) {
        if (x === 0) {
            const rightSum = total - leftSum;
            if (leftSum === rightSum) {
                ans += 2;
            } else if (leftSum === 0 || rightSum === 0) {
                ans += 1;
            }
        } else {
            leftSum += x;
        }
    }
    return ans;
};
