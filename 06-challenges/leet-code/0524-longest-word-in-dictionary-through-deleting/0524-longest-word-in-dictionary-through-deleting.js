// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

var findLongestWord = function(s, dictionary) {
    function isSubseq(word) {
        let si = 0;
        for (let i = 0; i < s.length && si < word.length; i++) {
            if (s[i] === word[si]) { si++; }
        }
        return si === word.length;
    }
    let result = "";
    for (const word of dictionary) {
        if (isSubseq(word)) {
            if (word.length > result.length || (word.length === result.length && word < result)) {
                result = word;
            }
        }
    }
    return result;
};
