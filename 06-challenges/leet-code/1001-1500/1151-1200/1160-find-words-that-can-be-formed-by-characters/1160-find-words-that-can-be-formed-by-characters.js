// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

var countCharacters = function(words, chars) {
    const avail = new Array(26).fill(0);
    for (const c of chars) {
        avail[c.charCodeAt(0) - 97]++;
    }
    let result = 0;
    for (const word of words) {
        const need = new Array(26).fill(0);
        for (const c of word) {
            need[c.charCodeAt(0) - 97]++;
        }
        let good = true;
        for (let i = 0; i < 26; i++) {
            if (need[i] > avail[i]) {
                good = false;
                break;
            }
        }
        if (good) {
            result += word.length;
        }
    }
    return result;
};
