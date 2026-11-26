// https://leetcode.com/problems/apply-operations-to-make-string-empty/

var lastNonEmptyString = function(s) {
    const freq = new Map();
    for (const c of s) freq.set(c, (freq.get(c)||0)+1);
    const maxFreq = Math.max(...freq.values());
    const seen = new Set();
    const result = [];
    for (let i = s.length-1; i >= 0; i--) {
        const c = s[i];
        if (freq.get(c) === maxFreq && !seen.has(c)) { result.push(c); seen.add(c); }
    }
    return result.reverse().join('');
};
