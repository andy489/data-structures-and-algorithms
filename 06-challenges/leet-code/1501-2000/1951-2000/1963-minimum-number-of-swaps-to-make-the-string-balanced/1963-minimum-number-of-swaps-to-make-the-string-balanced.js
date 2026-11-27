// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
var minSwaps = function(s) {
    let unmatched = 0;
    for (const c of s) {
        if (c === '[') {
            unmatched--;
        } else {
            unmatched++;
        }
        if (unmatched < 0) {
            unmatched = 0;
        }
    }
    return Math.ceil(unmatched / 2);
};
