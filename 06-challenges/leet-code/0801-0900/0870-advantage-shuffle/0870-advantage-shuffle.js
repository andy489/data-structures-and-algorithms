// https://leetcode.com/problems/advantage-shuffle/

var advantageCount = function(nums1, nums2) {
    nums1.sort((a, b) => a - b);
    const idx2 = nums2.map((_, i) => i).sort((a, b) => nums2[b] - nums2[a]);
    let lo = 0, hi = nums1.length - 1;
    const result = new Array(nums1.length);
    for (const i of idx2) {
        if (nums1[hi] > nums2[i]) {
            result[i] = nums1[hi--];
        } else {
            result[i] = nums1[lo++];
        }
    }
    return result;
};
