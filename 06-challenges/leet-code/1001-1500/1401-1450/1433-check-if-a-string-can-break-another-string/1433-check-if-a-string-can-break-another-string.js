// https://leetcode.com/problems/check-if-a-string-can-break-another-string/

var checkIfCanBreak = function(s1, s2) {
    const a = [...s1].sort(), b = [...s2].sort();
    const aGeB = a.every((c,i) => c >= b[i]);
    const bGeA = b.every((c,i) => c >= a[i]);
    return aGeB || bGeA;
};
