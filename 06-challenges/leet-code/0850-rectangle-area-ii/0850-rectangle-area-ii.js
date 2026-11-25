// https://leetcode.com/problems/rectangle-area-ii/

var rectangleArea = function(rectangles) {
    const MOD = 1000000007n;
    const xSet = new Set();
    for (const r of rectangles) { xSet.add(r[0]); xSet.add(r[2]); }
    const xs = [...xSet].sort((a, b) => a - b);
    let ans = 0n;
    for (let xi = 0; xi + 1 < xs.length; xi++) {
        const x1 = xs[xi], x2 = xs[xi + 1];
        const intervals = rectangles
            .filter(r => r[0] <= x1 && x2 <= r[2])
            .map(r => [r[1], r[3]])
            .sort((a, b) => a[0] - b[0]);
        let covered = 0, curStart = -1, curEnd = -1;
        for (const [y1, y2] of intervals) {
            if (y1 > curEnd) { covered += curEnd - curStart; curStart = y1; curEnd = y2; }
            else { curEnd = Math.max(curEnd, y2); }
        }
        covered += curEnd - curStart;
        ans = (ans + BigInt(x2 - x1) * BigInt(covered)) % MOD;
    }
    return Number(ans);
};
