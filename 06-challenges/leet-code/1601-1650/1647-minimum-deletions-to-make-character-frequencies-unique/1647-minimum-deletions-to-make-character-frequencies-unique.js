// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

var minDeletions = function(s) {
    const freq = new Array(26).fill(0);
    for (const c of s) {
        freq[c.charCodeAt(0) - 97]++;
    }
    freq.sort((a, b) => b - a);
    const seen = new Set();
    let deletions = 0;
    for (let f of freq) {
        while (f > 0 && seen.has(f)) {
            f--;
            deletions++;
        }
        seen.add(f);
    }
    return deletions;
};
