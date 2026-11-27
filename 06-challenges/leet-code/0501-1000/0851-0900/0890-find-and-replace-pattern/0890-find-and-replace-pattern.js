// https://leetcode.com/problems/find-and-replace-pattern/

var findAndReplacePattern = function(words, pattern) {
    function matches(word) {
        const wp = new Map(), pw = new Map();
        for (let i = 0; i < word.length; i++) {
            const w = word[i], p = pattern[i];
            if ((wp.has(w) && wp.get(w) !== p) || (pw.has(p) && pw.get(p) !== w)) return false;
            wp.set(w, p); pw.set(p, w);
        }
        return true;
    }
    return words.filter(matches);
};
