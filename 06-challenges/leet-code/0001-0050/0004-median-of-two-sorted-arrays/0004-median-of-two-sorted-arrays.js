// https://leetcode.com/problems/median-of-two-sorted-arrays/

var findMedianSortedArrays = function(nums1, nums2) {
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }
    const n1 = nums1.length;
    const n2 = nums2.length;
    let lo = 0;
    let hi = n1;

    while (lo <= hi) {
        const pivot1 = Math.floor((lo + hi) / 2);
        const pivot2 = Math.floor((n1 + n2 + 1) / 2) - pivot1;

        const l1 = pivot1 === 0 ? -Infinity : nums1[pivot1 - 1];
        const r1 = pivot1 === n1 ? Infinity : nums1[pivot1];
        const l2 = pivot2 === 0 ? -Infinity : nums2[pivot2 - 1];
        const r2 = pivot2 === n2 ? Infinity : nums2[pivot2];

        if (l1 <= r2 && l2 <= r1) {
            if ((n1 + n2) % 2 === 1) {
                return Math.max(l1, l2);
            }
            return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        }
        if (l1 > r2) {
            hi = pivot1 - 1;
        } else {
            lo = pivot1 + 1;
        }
    }

    return -1;
};
