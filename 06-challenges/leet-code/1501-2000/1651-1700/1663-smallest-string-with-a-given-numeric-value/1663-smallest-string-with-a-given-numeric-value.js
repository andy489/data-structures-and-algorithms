// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

var getSmallestString = function(n, k) {
    const result = new Array(n);
    for (let i = n - 1; i >= 0; i--) {
        const val = Math.min(26, k - i);
        result[i] = String.fromCharCode(96 + val);
        k -= val;
    }
    return result.join('');
};
