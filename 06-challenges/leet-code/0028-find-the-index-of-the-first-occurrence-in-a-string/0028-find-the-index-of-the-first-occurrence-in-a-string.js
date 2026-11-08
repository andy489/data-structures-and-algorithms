// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

// Solution: Sliding Window — O(n·m) time, O(1) space
var strStr = function(haystack, needle) {
    const n = haystack.length, m = needle.length;
    for (let i = 0; i <= n - m; i++) {
        if (haystack.substring(i, i + m) === needle) {
            return i;
        }
    }
    return -1;
};

// Solution2: KMP — O(n + m) time, O(m) space
// https://cp-algorithms.com/string/prefix-function.html
var strStr2 = function(haystack, needle) {
    const n = haystack.length, m = needle.length;
    const lps = buildLps(needle);
    let j = 0; // number of needle chars matched so far
    for (let i = 0; i < n; i++) {
        // mismatch after j matches: fall back using lps to skip re-checking
        while (j > 0 && haystack[i] !== needle[j]) {
            j = lps[j - 1];
        }
        if (haystack[i] === needle[j]) {
            j++;
        }
        if (j === m) { // full needle matched
            return i - m + 1;
        }
    }
    return -1;
};

// lps[i] = length of longest proper prefix of needle[0..i] that is also a suffix
function buildLps(needle) {
    const m = needle.length;
    const lps = new Array(m).fill(0);
    let len = 0, i = 1; // len = length of previous longest prefix-suffix
    while (i < m) {
        if (needle[i] === needle[len]) {
            lps[i++] = ++len;
        } else if (len > 0) {
            len = lps[len - 1]; // try shorter prefix, don't advance i
        } else {
            lps[i++] = 0;
        }
    }
    return lps;
}
