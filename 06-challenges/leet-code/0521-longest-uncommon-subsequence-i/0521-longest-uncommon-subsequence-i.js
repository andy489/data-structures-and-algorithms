// https://leetcode.com/problems/longest-uncommon-subsequence-i/

var findLUSlength = function(a, b) {
    return a === b ? -1 : Math.max(a.length, b.length);
};
