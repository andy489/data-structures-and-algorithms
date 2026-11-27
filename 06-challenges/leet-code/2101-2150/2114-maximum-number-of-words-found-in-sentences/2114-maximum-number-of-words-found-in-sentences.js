// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
var mostWordsFound = function(sentences) {
    let max = 0;
    for (const s of sentences) {
        let count = 1;
        for (const c of s) {
            if (c === ' ') count++;
        }
        max = Math.max(max, count);
    }
    return max;
};
