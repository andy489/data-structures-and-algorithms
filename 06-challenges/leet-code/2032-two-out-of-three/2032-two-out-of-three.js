// https://leetcode.com/problems/two-out-of-three/

// Solution: Set Union — O(n1+n2+n3) time, O(n) space
var twoOutOfThree = function(nums1, nums2, nums3) {
    const count = new Map();
    for (const arr of [nums1, nums2, nums3]) {
        for (const x of new Set(arr)) count.set(x, (count.get(x) || 0) + 1);
    }
    return [...count.entries()].filter(([, c]) => c >= 2).map(([x]) => x);
};
