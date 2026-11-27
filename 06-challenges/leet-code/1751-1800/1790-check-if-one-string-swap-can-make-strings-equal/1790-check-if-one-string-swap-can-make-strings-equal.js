// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

var areAlmostEqual = function(s1, s2) {
    const diffs = [];
    for (let i = 0; i < s1.length; i++) {
        if (s1[i] !== s2[i]) {
            diffs.push(i);
            if (diffs.length > 2) return false;
        }
    }
    if (diffs.length === 0) return true;
    if (diffs.length === 2) {
        const [i, j] = diffs;
        return s1[i] === s2[j] && s1[j] === s2[i];
    }
    return false;
};
