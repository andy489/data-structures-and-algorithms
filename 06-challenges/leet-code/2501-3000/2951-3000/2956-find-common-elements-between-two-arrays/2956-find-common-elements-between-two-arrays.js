// https://leetcode.com/problems/find-common-elements-between-two-arrays/
var findIntersectionValues = function(nums1, nums2) {
    const set1 = new Set(nums1);
    const set2 = new Set(nums2);
    const answer1 = nums1.filter(x => set2.has(x)).length;
    const answer2 = nums2.filter(x => set1.has(x)).length;
    return [answer1, answer2];
};
