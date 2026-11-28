// https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/

var minOperations = function(queries) {
    let total = 0n;
    for (const [l, r] of queries) {
        let steps = 0n;
        let lo = 1, hi = 3;
        let level = 1;
        while (lo <= r) {
            const overlapL = Math.max(l, lo);
            const overlapR = Math.min(r, hi);
            if (overlapL <= overlapR) {
                steps += BigInt(overlapR - overlapL + 1) * BigInt(level);
            }
            lo = hi + 1;
            hi = hi * 4 + 3;
            level++;
        }
        total += (steps + 1n) / 2n;
    }
    return Number(total);
};
