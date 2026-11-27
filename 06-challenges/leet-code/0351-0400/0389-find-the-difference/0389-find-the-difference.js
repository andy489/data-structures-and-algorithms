// https://leetcode.com/problems/find-the-difference/

// Solution: XOR — O(n) time, O(1) space
var findTheDifference = function(s, t) {
    let xor = 0;
    for (const c of s + t) xor ^= c.charCodeAt(0);
    return String.fromCharCode(xor);
};
