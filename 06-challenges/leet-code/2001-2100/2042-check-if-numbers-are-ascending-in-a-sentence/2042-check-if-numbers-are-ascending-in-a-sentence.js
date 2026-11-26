// https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/

// Solution: Tokenize and Compare — O(n) time, O(1) space
var areNumbersAscending = function(s) {
    let prev = 0;
    for (const token of s.split(' ')) {
        if (/^\d+$/.test(token)) {
            const num = parseInt(token);
            if (num <= prev) return false;
            prev = num;
        }
    }
    return true;
};
