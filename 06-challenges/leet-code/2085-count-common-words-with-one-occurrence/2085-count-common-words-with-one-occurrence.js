// https://leetcode.com/problems/count-common-words-with-one-occurrence/

// Solution: Frequency Count — O(n + m) time, O(n + m) space
var countWords = function(words1, words2) {
    const freq1 = new Map(), freq2 = new Map();
    for (const w of words1) freq1.set(w, (freq1.get(w) || 0) + 1);
    for (const w of words2) freq2.set(w, (freq2.get(w) || 0) + 1);
    let count = 0;
    for (const [w, f] of freq1) { if (f === 1 && freq2.get(w) === 1) count++; }
    return count;
};
