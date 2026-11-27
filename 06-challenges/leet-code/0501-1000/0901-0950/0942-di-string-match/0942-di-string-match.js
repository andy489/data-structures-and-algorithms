// https://leetcode.com/problems/di-string-match/

var diStringMatch = function(s) {
    let lo = 0, hi = s.length;
    const result = [];
    for (const c of s) result.push(c === 'I' ? lo++ : hi--);
    result.push(lo);
    return result;
};
