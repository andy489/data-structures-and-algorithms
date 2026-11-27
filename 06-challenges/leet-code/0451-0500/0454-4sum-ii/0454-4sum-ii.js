// https://leetcode.com/problems/4sum-ii/

var fourSumCount = function(nums1, nums2, nums3, nums4) {
    const pairSums = new Map();
    for (const a of nums1) {
        for (const b of nums2) {
            const s = a + b;
            pairSums.set(s, (pairSums.get(s) || 0) + 1);
        }
    }
    let count = 0;
    for (const c of nums3) {
        for (const d of nums4) {
            count += pairSums.get(-(c + d)) || 0;
        }
    }
    return count;
};
