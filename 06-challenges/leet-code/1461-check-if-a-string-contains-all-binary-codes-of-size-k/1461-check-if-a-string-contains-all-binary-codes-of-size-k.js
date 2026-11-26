// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

var hasAllCodes = function(s, k) {
    const seen = new Set();
    for (let i = 0; i <= s.length-k; i++) seen.add(s.slice(i,i+k));
    return seen.size === 1 << k;
};
