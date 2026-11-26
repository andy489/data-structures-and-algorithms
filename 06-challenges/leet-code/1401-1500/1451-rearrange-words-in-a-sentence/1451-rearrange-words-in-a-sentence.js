// https://leetcode.com/problems/rearrange-words-in-a-sentence/

var arrangeWords = function(text) {
    const words = text.toLowerCase().split(' ');
    words.sort((a, b) => a.length - b.length);
    words[0] = words[0][0].toUpperCase() + words[0].slice(1);
    return words.join(' ');
};
