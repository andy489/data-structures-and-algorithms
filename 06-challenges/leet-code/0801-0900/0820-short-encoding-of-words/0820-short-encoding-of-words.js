// https://leetcode.com/problems/short-encoding-of-words/

var minimumLengthEncoding = function(words) {
    const s = new Set(words);
    for (const w of words) {
        for (let i = 1; i < w.length; i++) {
            s.delete(w.slice(i));
        }
    }
    let len = 0;
    for (const w of s) { len += w.length + 1; }
    return len;
};
