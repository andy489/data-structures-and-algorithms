// https://leetcode.com/problems/number-of-matching-subsequences/

var numMatchingSubseq = function(s, words) {
    const buckets = Array.from({length: 26}, () => []);
    for (const w of words) buckets[w.charCodeAt(0) - 97].push([w, 0]);
    let count = 0;
    for (const c of s) {
        const ci = c.charCodeAt(0) - 97;
        const waiting = buckets[ci];
        buckets[ci] = [];
        for (const [w, pos] of waiting) {
            if (pos + 1 === w.length) {
                count++;
            } else {
                buckets[w.charCodeAt(pos + 1) - 97].push([w, pos + 1]);
            }
        }
    }
    return count;
};
