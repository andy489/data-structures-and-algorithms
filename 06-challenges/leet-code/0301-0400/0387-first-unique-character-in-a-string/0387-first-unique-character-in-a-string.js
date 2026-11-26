// https://leetcode.com/problems/first-unique-character-in-a-string/

// Solution: Frequency Count — O(n) time, O(1) space
var firstUniqChar = function(s) {
    const count = new Array(26).fill(0);
    for (const c of s) count[c.charCodeAt(0) - 97]++;
    for (let i = 0; i < s.length; i++) {
        if (count[s.charCodeAt(i) - 97] === 1) return i;
    }
    return -1;
};
