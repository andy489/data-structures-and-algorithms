// https://leetcode.com/problems/word-subsets/

var wordSubsets = function(words1, words2) {
    const need = new Array(26).fill(0);
    for (const b of words2) {
        const freq = new Array(26).fill(0);
        for (const c of b) freq[c.charCodeAt(0) - 97]++;
        for (let i = 0; i < 26; i++) need[i] = Math.max(need[i], freq[i]);
    }
    return words1.filter(a => {
        const freq = new Array(26).fill(0);
        for (const c of a) freq[c.charCodeAt(0) - 97]++;
        return need.every((v, i) => freq[i] >= v);
    });
};
