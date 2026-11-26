// https://leetcode.com/problems/unique-number-of-occurrences/

var uniqueOccurrences = function(arr) {
    const freq = new Map();
    for (const x of arr) freq.set(x, (freq.get(x) || 0) + 1);
    return new Set(freq.values()).size === freq.size;
};
