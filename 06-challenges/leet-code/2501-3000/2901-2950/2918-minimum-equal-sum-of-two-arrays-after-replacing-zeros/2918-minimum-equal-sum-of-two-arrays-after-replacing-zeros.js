// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/

var minSum = function(nums1, nums2) {
    let sum1 = 0, zeros1 = 0;
    for (const x of nums1) { sum1 += x; if (x === 0) zeros1++; }
    let sum2 = 0, zeros2 = 0;
    for (const x of nums2) { sum2 += x; if (x === 0) zeros2++; }

    const min1 = sum1 + zeros1;
    const min2 = sum2 + zeros2;

    if (min1 === min2) return min1;
    if (min1 < min2) return zeros1 > 0 ? min2 : -1;
    return zeros2 > 0 ? min1 : -1;
};
