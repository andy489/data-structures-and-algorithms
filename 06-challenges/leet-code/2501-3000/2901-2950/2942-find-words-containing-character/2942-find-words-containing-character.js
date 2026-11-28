// https://leetcode.com/problems/find-words-containing-character/

var findWordsContaining = function(words, x) {
    const result = [];
    for (let i = 0; i < words.length; i++) {
        if (words[i].includes(x)) {
            result.push(i);
        }
    }
    return result;
};
