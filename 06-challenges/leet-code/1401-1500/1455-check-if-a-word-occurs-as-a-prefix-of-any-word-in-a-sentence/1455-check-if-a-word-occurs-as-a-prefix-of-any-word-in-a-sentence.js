// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

var isPrefixOfWord = function(sentence, searchWord) {
    const words = sentence.split(' ');
    for (let i = 0; i < words.length; i++)
        if (words[i].startsWith(searchWord)) return i + 1;
    return -1;
};
