// https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/

// Solution: Frequency Count — O(n) time, O(1) space
var checkAlmostEquivalent = function(word1, word2) {
    const freq = new Array(26).fill(0);
    for (const c of word1) freq[c.charCodeAt(0) - 97]++;
    for (const c of word2) freq[c.charCodeAt(0) - 97]--;
    return freq.every(f => Math.abs(f) <= 3);
};
