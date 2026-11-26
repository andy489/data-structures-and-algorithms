// https://leetcode.com/problems/two-best-non-overlapping-events/

// Solution: Sort + Binary Search — O(n log n) time, O(n) space
var maxTwoEvents = function(events) {
    events.sort((a, b) => a[1] - b[1]);
    const n = events.length;
    const pref = new Array(n);
    pref[0] = events[0][2];
    for (let i = 1; i < n; i++) pref[i] = Math.max(pref[i-1], events[i][2]);
    const ends = events.map(e => e[1]);
    const bs = (t) => { let lo=0, hi=n-1, r=-1; while(lo<=hi){const m=(lo+hi)>>1; ends[m]<t?r=m++(lo=m+1):hi=m-1;} return r; };
    let res = 0;
    for (let i = 0; i < n; i++) {
        const val = events[i][2];
        res = Math.max(res, val);
        const j = bs(events[i][0]);
        if (j >= 0) res = Math.max(res, val + pref[j]);
    }
    return res;
};
