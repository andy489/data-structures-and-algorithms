// https://leetcode.com/problems/number-of-segments-in-a-string/

var countSegments = function(s) {
    let count = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] !== ' ' && (i === 0 || s[i - 1] === ' ')) {
            count++;
        }
    }
    return count;
};
