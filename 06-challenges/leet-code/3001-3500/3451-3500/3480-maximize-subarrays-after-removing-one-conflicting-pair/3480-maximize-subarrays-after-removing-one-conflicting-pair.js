// https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/

var maxSubarrays = function(n, conflictingPairs) {
    const m = conflictingPairs.length;
    const byB = Array.from({length: n + 1}, () => []);
    for (let i = 0; i < m; i++) {
        const a = Math.min(conflictingPairs[i][0], conflictingPairs[i][1]);
        const b = Math.max(conflictingPairs[i][0], conflictingPairs[i][1]);
        byB[b].push([a, i]);
    }
    let baseTotal = 0n;
    const bonus = new Array(m).fill(0n);
    let t1 = 0, t2 = 0, t1Idx = -1;
    for (let r = 1; r <= n; r++) {
        for (const [a, idx] of byB[r]) {
            if (a >= t1) { t2 = t1; t1 = a; t1Idx = idx; }
            else if (a > t2) { t2 = a; }
        }
        baseTotal += BigInt(r - t1);
        if (t1Idx >= 0) bonus[t1Idx] += BigInt(t1 - t2);
    }
    let best = 0n;
    for (const b of bonus) { if (b > best) best = b; }
    return baseTotal + best;
};
