// https://leetcode.com/problems/determine-if-two-strings-are-close/

var closeStrings = function(word1, word2) {
    if (word1.length !== word2.length) {
        return false;
    }
    const freq1 = new Array(26).fill(0);
    const freq2 = new Array(26).fill(0);
    for (const c of word1) {
        freq1[c.charCodeAt(0) - 97]++;
    }
    for (const c of word2) {
        freq2[c.charCodeAt(0) - 97]++;
    }
    for (let i = 0; i < 26; i++) {
        if ((freq1[i] === 0) !== (freq2[i] === 0)) {
            return false;
        }
    }
    freq1.sort((a, b) => a - b);
    freq2.sort((a, b) => a - b);
    return freq1.every((v, i) => v === freq2[i]);
};
