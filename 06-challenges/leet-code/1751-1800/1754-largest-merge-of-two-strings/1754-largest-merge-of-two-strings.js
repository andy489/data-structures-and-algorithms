// https://leetcode.com/problems/largest-merge-of-two-strings/

var largestMerge = function(word1, word2) {
    let i = 0, j = 0;
    const parts = [];
    while (i < word1.length && j < word2.length) {
        if (word1.slice(i) >= word2.slice(j)) {
            parts.push(word1[i++]);
        } else {
            parts.push(word2[j++]);
        }
    }
    parts.push(word1.slice(i));
    parts.push(word2.slice(j));
    return parts.join('');
};
