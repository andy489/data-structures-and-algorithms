// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

// Solution: Math (Work Upwards) — O(log n) time, O(log n) space
var pathInZigZagTree = function(label) {
    const path = [];
    while (label >= 1) {
        path.push(label);
        const row = Math.floor(Math.log2(label));
        const rowMin = 1 << row;
        const rowMax = (1 << (row + 1)) - 1;
        const mirror = rowMin + rowMax - label;
        label = Math.floor(mirror / 2);
    }
    return path.reverse();
};
