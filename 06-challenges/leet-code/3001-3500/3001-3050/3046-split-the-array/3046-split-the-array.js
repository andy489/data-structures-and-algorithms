// https://leetcode.com/problems/split-the-array/

var isPossibleToSplit = function(nums) {
    const freq = new Map();
    for (const x of nums) freq.set(x, (freq.get(x) || 0) + 1);
    for (const f of freq.values()) if (f > 2) return false;
    return true;
};
