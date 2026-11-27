// https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
var rearrangeArray = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const ans = new Array(n);
    let lo = 0, hi = Math.floor((n + 1) / 2);
    for (let i = 0; i < n; i++) {
        if (i % 2 === 0) {
            ans[i] = nums[lo++];
        } else {
            ans[i] = nums[hi++];
        }
    }
    return ans;
};
