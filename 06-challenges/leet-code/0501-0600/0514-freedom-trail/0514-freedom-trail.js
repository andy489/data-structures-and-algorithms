// https://leetcode.com/problems/freedom-trail/

var findRotateSteps = function(ring, key) {
    const n = ring.length, m = key.length;
    const positions = {};
    for (let i = 0; i < n; i++) {
        const c = ring[i];
        if (!positions[c]) positions[c] = [];
        positions[c].push(i);
    }
    const memo = new Map();
    function dp(ki, ri) {
        if (ki === m) return 0;
        const k = `${ki},${ri}`;
        if (memo.has(k)) return memo.get(k);
        let best = Infinity;
        for (const nxt of positions[key[ki]]) {
            const diff = Math.abs(ri - nxt);
            const cost = Math.min(diff, n - diff) + 1 + dp(ki + 1, nxt);
            best = Math.min(best, cost);
        }
        memo.set(k, best);
        return best;
    }
    return dp(0, 0);
};
