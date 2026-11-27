// https://leetcode.com/problems/number-of-different-integers-in-a-string/

var numDifferentIntegers = function(word) {
    const nums = word.match(/\d+/g) || [];
    const seen = new Set();
    for (const n of nums) {
        seen.add(n.replace(/^0+(?=\d)/, ''));
    }
    return seen.size;
};
