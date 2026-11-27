// https://leetcode.com/problems/maximum-number-of-balloons/

// Solution: Frequency Count — O(n) time, O(1) space
var maxNumberOfBalloons = function(text) {
    let b = 0, a = 0, l = 0, o = 0, n = 0;
    for (const c of text) {
        if (c === 'b') { b++; }
        else if (c === 'a') { a++; }
        else if (c === 'l') { l++; }
        else if (c === 'o') { o++; }
        else if (c === 'n') { n++; }
    }
    return Math.min(b, a, Math.floor(l / 2), Math.floor(o / 2), n);
};
