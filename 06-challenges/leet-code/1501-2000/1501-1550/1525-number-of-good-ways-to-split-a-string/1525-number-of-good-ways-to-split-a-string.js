// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

var numSplits = function(s) {
    const right = new Array(26).fill(0);
    for (const c of s) {
        right[c.charCodeAt(0) - 97]++;
    }
    let rightDistinct = right.filter(v => v > 0).length;
    const left = new Array(26).fill(0);
    let leftDistinct = 0;
    let result = 0;
    for (const c of s) {
        const idx = c.charCodeAt(0) - 97;
        if (left[idx]++ === 0) leftDistinct++;
        if (--right[idx] === 0) rightDistinct--;
        if (leftDistinct === rightDistinct) result++;
    }
    return result;
};
