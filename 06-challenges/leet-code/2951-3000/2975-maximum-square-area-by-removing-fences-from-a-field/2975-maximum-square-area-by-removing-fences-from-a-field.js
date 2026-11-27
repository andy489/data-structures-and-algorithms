// https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/
var maximumArea = function(m, n, hFences, vFences) {
    const MOD = 1000000007n;

    const computeGaps = (maxPos, fences) => {
        const positions = [1, ...fences, maxPos].sort((a, b) => a - b);
        const gaps = new Set();
        for (let i = 0; i < positions.length; i++) {
            for (let j = i + 1; j < positions.length; j++) {
                gaps.add(positions[j] - positions[i]);
            }
        }
        return gaps;
    };

    const hGaps = computeGaps(m, hFences);
    const vGaps = computeGaps(n, vFences);
    let best = -1;
    for (const gap of hGaps) {
        if (vGaps.has(gap)) {
            best = Math.max(best, gap);
        }
    }
    if (best === -1) return -1;
    const b = BigInt(best);
    return Number((b * b) % MOD);
};
