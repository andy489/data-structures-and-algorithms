// https://leetcode.com/problems/length-of-last-word/

// Solution: Reverse Scan — O(n) time, O(1) space
var lengthOfLastWord = function(s) {
    let i = s.length - 1, count = 0;
    while (i >= 0 && s[i] === ' ') {
        i--;
    }
    while (i >= 0 && s[i] !== ' ') {
        count++;
        i--;
    }
    return count;
};
