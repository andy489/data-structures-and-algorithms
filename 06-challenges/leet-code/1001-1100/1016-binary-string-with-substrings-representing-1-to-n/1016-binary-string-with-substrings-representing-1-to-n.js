// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/

var queryString = function(s, n) {
    for (let i = n; i > Math.max(0, n - 2 * s.length); i--) {
        if (!s.includes(i.toString(2))) return false;
    }
    return true;
};
