// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

var getNoZeroIntegers = function(n) {
    const hasZero = x => String(x).includes('0');
    for (let a = 1; a < n; a++) {
        if (!hasZero(a) && !hasZero(n-a)) return [a, n-a];
    }
    return [];
};
