// https://leetcode.com/problems/get-the-maximum-score/

var maxSum = function(nums1, nums2) {
    const MOD = BigInt(1e9 + 7);
    let i = 0, j = 0;
    let sum1 = 0n, sum2 = 0n;
    while (i < nums1.length || j < nums2.length) {
        if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
            sum1 += BigInt(nums1[i++]);
        } else if (j < nums2.length && (i >= nums1.length || nums2[j] < nums1[i])) {
            sum2 += BigInt(nums2[j++]);
        } else {
            const best = (sum1 > sum2 ? sum1 : sum2) + BigInt(nums1[i]);
            sum1 = sum2 = best;
            i++; j++;
        }
    }
    return Number((sum1 > sum2 ? sum1 : sum2) % MOD);
};
