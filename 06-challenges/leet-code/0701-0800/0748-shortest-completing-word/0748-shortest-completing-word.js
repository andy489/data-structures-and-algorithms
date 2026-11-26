// https://leetcode.com/problems/shortest-completing-word/

var shortestCompletingWord = function(licensePlate, words) {
    const need = new Array(26).fill(0);
    for (const c of licensePlate.toLowerCase()) {
        if (c >= 'a' && c <= 'z') need[c.charCodeAt(0) - 97]++;
    }
    let result = null;
    for (const word of words) {
        const have = new Array(26).fill(0);
        for (const c of word) have[c.charCodeAt(0) - 97]++;
        if (need.every((cnt, i) => have[i] >= cnt)) {
            if (!result || word.length < result.length) result = word;
        }
    }
    return result;
};
