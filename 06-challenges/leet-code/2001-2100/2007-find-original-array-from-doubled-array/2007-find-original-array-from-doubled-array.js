// https://leetcode.com/problems/find-original-array-from-doubled-array/

// Solution: Sort and Greedy — O(n log n) time, O(n) space
var findOriginalArray = function(changed) {
    if (changed.length % 2 !== 0) return [];
    changed.sort((a, b) => a - b);
    const freq = new Map();
    for (const x of changed) freq.set(x, (freq.get(x) || 0) + 1);
    const original = [];
    for (const x of changed) {
        if (!freq.get(x)) continue;
        freq.set(x, freq.get(x) - 1);
        if (!freq.get(2 * x)) return [];
        freq.set(2 * x, freq.get(2 * x) - 1);
        original.push(x);
    }
    return original;
};
