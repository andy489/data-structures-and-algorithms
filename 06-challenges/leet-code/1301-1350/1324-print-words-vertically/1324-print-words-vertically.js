// https://leetcode.com/problems/print-words-vertically/

var printVertically = function(s) {
    const words = s.split(' ');
    const maxLen = Math.max(...words.map(w => w.length));
    const res = [];
    for (let i = 0; i < maxLen; i++) {
        res.push(words.map(w => i < w.length ? w[i] : ' ').join('').trimEnd());
    }
    return res;
};
