// https://leetcode.com/problems/expressive-words/

var expressiveWords = function(s, words) {
    function isStretchy(w) {
        let i = 0, j = 0;
        while (i < s.length && j < w.length) {
            if (s[i] !== w[j]) { return false; }
            let sc = 1, wc = 1;
            while (i + sc < s.length && s[i + sc] === s[i]) { sc++; }
            while (j + wc < w.length && w[j + wc] === w[j]) { wc++; }
            if (sc !== wc && (sc < 3 || sc < wc)) { return false; }
            i += sc; j += wc;
        }
        return i === s.length && j === w.length;
    }
    return words.filter(isStretchy).length;
};
