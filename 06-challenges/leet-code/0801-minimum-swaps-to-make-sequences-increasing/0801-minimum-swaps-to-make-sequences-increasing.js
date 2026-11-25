// https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

var minSwap = function(nums1, nums2) {
    let keep = 0, swap = 1;
    for (let i = 1; i < nums1.length; i++) {
        let newKeep = Infinity, newSwap = Infinity;
        if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
            newKeep = Math.min(newKeep, keep);
            newSwap = Math.min(newSwap, swap + 1);
        }
        if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
            newKeep = Math.min(newKeep, swap);
            newSwap = Math.min(newSwap, keep + 1);
        }
        keep = newKeep;
        swap = newSwap;
    }
    return Math.min(keep, swap);
};
