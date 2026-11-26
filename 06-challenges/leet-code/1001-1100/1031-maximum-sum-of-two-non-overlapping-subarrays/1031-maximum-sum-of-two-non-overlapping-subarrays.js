// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

var maxSumTwoNoOverlap = function(nums, firstLen, secondLen) {
    const n = nums.length;
    const pre = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
    const helper = (l, r) => {
        let res = 0, maxL = 0;
        for (let i = l + r; i < pre.length; i++) {
            maxL = Math.max(maxL, pre[i - r] - pre[i - r - l]);
            res = Math.max(res, maxL + pre[i] - pre[i - r]);
        }
        return res;
    };
    return Math.max(helper(firstLen, secondLen), helper(secondLen, firstLen));
};
