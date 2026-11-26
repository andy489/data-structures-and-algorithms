// https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/

var minOperations = function(nums1, nums2) {
    let sum1 = nums1.reduce((a, b) => a + b, 0);
    let sum2 = nums2.reduce((a, b) => a + b, 0);
    if (sum1 === sum2) return 0;
    if (sum1 < sum2) {
        [nums1, nums2] = [nums2, nums1];
        [sum1, sum2] = [sum2, sum1];
    }
    let diff = sum1 - sum2;
    const gains = new Array(6).fill(0);
    for (const x of nums1) gains[x - 1]++;
    for (const x of nums2) gains[6 - x]++;
    let ops = 0;
    for (let g = 5; g >= 1 && diff > 0; g--) {
        const use = Math.min(gains[g], Math.ceil(diff / g));
        ops += use;
        diff -= use * g;
    }
    return diff <= 0 ? ops : -1;
};
