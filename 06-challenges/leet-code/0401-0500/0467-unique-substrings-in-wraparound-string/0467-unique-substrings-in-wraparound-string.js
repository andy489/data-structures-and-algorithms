// https://leetcode.com/problems/unique-substrings-in-wraparound-string/

var findSubstringInWraproundString = function(p) {
    const maxLenEndingAt = new Array(26).fill(0);
    let curLen = 0;
    for (let i = 0; i < p.length; i++) {
        const idx = p.charCodeAt(i) - 97;
        if (i > 0 && (p.charCodeAt(i) - p.charCodeAt(i - 1) + 26) % 26 === 1) {
            curLen++;
        } else {
            curLen = 1;
        }
        if (curLen > maxLenEndingAt[idx]) {
            maxLenEndingAt[idx] = curLen;
        }
    }
    return maxLenEndingAt.reduce((a, b) => a + b, 0);
};
