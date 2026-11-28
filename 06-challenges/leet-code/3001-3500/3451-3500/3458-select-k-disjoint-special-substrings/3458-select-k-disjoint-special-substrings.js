// https://leetcode.com/problems/select-k-disjoint-special-substrings/

var maxSubstringLength = function(s, k) {
    const n = s.length;
    const first = {}, last = {};
    for (let i = 0; i < n; i++) {
        const c = s[i];
        if (!(c in first)) first[c] = i;
        last[c] = i;
    }

    const intervals = [];
    const used = new Set();
    for (const c of Object.keys(first)) {
        if (used.has(c)) continue;
        let lo = first[c], hi = last[c];
        let changed = true;
        while (changed) {
            changed = false;
            for (let i = lo; i <= hi; i++) {
                const cc = s[i];
                if (first[cc] < lo) { lo = first[cc]; changed = true; }
                if (last[cc] > hi) { hi = last[cc]; changed = true; }
            }
        }
        if (lo === 0 && hi === n - 1) continue;
        for (let i = lo; i <= hi; i++) used.add(s[i]);
        intervals.push([lo, hi]);
    }

    intervals.sort((a, b) => a[1] - b[1]);
    let count = 0, prevEnd = -1;
    for (const [lo, hi] of intervals) {
        if (lo > prevEnd) {
            count++;
            prevEnd = hi;
        }
    }
    return count >= k;
};
