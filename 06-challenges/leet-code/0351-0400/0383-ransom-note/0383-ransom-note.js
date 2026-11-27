// https://leetcode.com/problems/ransom-note/

// Solution: Frequency Count — O(n) time, O(1) space
var canConstruct = function(ransomNote, magazine) {
    const count = new Array(26).fill(0);
    for (const c of magazine) count[c.charCodeAt(0) - 97]++;
    for (const c of ransomNote) {
        if (--count[c.charCodeAt(0) - 97] < 0) return false;
    }
    return true;
};
