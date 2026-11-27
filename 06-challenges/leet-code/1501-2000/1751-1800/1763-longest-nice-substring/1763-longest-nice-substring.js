// https://leetcode.com/problems/longest-nice-substring/

var longestNiceSubstring = function(s) {
    if (s.length < 2) return "";
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        const other = c === c.toUpperCase() ? c.toLowerCase() : c.toUpperCase();
        if (!s.includes(other)) {
            const left = longestNiceSubstring(s.slice(0, i));
            const right = longestNiceSubstring(s.slice(i + 1));
            return left.length >= right.length ? left : right;
        }
    }
    return s;
};
