// https://leetcode.com/problems/truncate-sentence/

var truncateSentence = function(s, k) {
    return s.split(' ').slice(0, k).join(' ');
};
