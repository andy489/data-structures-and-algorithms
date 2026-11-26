// https://leetcode.com/problems/merge-strings-alternately/

var mergeAlternately = function(word1, word2) {
    let result = "";
    let i = 0, j = 0;
    while (i < word1.length && j < word2.length) {
        result += word1[i++] + word2[j++];
    }
    return result + word1.slice(i) + word2.slice(j);
};
