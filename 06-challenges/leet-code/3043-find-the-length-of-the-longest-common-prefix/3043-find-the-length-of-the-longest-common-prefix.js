// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

var longestCommonPrefix = function(arr1, arr2) {
    const prefixes = new Set();
    for (let x of arr1) { while (x > 0) { prefixes.add(x); x = Math.floor(x/10); } }
    let maxLen = 0;
    for (let y of arr2) {
        while (y > 0) {
            if (prefixes.has(y)) { maxLen = Math.max(maxLen, String(y).length); break; }
            y = Math.floor(y/10);
        }
    }
    return maxLen;
};
