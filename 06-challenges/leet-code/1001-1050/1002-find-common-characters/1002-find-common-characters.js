// https://leetcode.com/problems/find-common-characters/

var commonChars = function(words) {
    const minFreq = new Array(26).fill(Infinity);
    for (const word of words) {
        const freq = new Array(26).fill(0);
        for (const c of word) freq[c.charCodeAt(0) - 97]++;
        for (let i = 0; i < 26; i++) minFreq[i] = Math.min(minFreq[i], freq[i]);
    }
    const result = [];
    for (let i = 0; i < 26; i++) {
        for (let j = 0; j < minFreq[i]; j++) result.push(String.fromCharCode(97 + i));
    }
    return result;
};
