// https://leetcode.com/problems/palindrome-rearrangement-queries/
var canMakePalindromeQueries = function(s, queries) {
    const n = s.length;
    const half = n >> 1;

    const prefL = Array.from({length: half + 1}, () => new Array(26).fill(0));
    const prefR = Array.from({length: half + 1}, () => new Array(26).fill(0));
    for (let i = 0; i < half; i++) {
        prefL[i + 1] = [...prefL[i]];
        prefL[i + 1][s.charCodeAt(i) - 97]++;
        prefR[i + 1] = [...prefR[i]];
        prefR[i + 1][s.charCodeAt(n - 1 - i) - 97]++;
    }
    const mismatch = new Array(half + 1).fill(0);
    for (let i = 0; i < half; i++) {
        mismatch[i + 1] = mismatch[i] + (s[i] !== s[n - 1 - i] ? 1 : 0);
    }

    const rangeCount = (pref, l, r) => {
        return pref[r + 1].map((v, c) => v - pref[l][c]);
    };

    return queries.map(([a, b, c, d]) => {
        const cl = n - 1 - d, dl = n - 1 - c;
        const lo = Math.min(a, cl), hi = Math.max(b, dl);
        const outside = mismatch[lo] + mismatch[half] - mismatch[hi + 1];
        if (outside > 0) return false;
        const cntL = rangeCount(prefL, a, b);
        const cntR = rangeCount(prefR, cl, dl);
        return cntL.every((v, c) => v === cntR[c]);
    });
};
