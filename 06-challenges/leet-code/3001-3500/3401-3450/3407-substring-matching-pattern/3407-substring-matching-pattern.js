// https://leetcode.com/problems/substring-matching-pattern/
var hasMatch = function(s, p) {
    const starIdx = p.indexOf('*');
    const prefix = p.substring(0, starIdx);
    const suffix = p.substring(starIdx + 1);
    const n = s.length;
    const pLen = prefix.length, sLen = suffix.length;
    for (let i = 0; i + pLen <= n; i++) {
        if (s.startsWith(prefix, i)) {
            const start = i + pLen;
            for (let j = start; j + sLen <= n; j++) {
                if (s.startsWith(suffix, j)) {
                    return true;
                }
            }
        }
    }
    return false;
};
