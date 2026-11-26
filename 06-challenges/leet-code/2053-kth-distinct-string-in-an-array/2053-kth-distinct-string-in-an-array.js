// https://leetcode.com/problems/kth-distinct-string-in-an-array/

// Solution: Frequency Count — O(n) time, O(n) space
var kthDistinct = function(arr, k) {
    const freq = new Map();
    for (const s of arr) freq.set(s, (freq.get(s) || 0) + 1);
    let count = 0;
    for (const s of arr) { if (freq.get(s) === 1 && ++count === k) return s; }
    return '';
};
