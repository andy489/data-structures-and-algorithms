// https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/

var maxRectangleArea = function(xCoord, yCoord) {
    const n = xCoord.length;

    // Coordinate compress y
    const sortedY = [...new Set(yCoord)].sort((a, b) => a - b);
    const yRankMap = new Map(sortedY.map((y, i) => [y, i]));
    const m = sortedY.length;

    // BIT on compressed y
    const bit = new Int32Array(m + 1);
    const update = (i, delta = 1) => {
        for (i++; i <= m; i += i & (-i)) bit[i] += delta;
    };
    const query = (i) => {
        let s = 0;
        for (i++; i > 0; i -= i & (-i)) s += bit[i];
        return s;
    };
    const rangeQuery = (l, r) => l > r ? 0 : query(r) - (l > 0 ? query(l - 1) : 0);

    // Group by x
    const byX = new Map();
    for (let i = 0; i < n; i++) {
        if (!byX.has(xCoord[i])) byX.set(xCoord[i], []);
        byX.get(xCoord[i]).push(yCoord[i]);
    }
    const xs = [...byX.keys()].sort((a, b) => b - a);

    const pairToX = new Map();
    let maxArea = -1n;

    for (const x of xs) {
        const ys = byX.get(x).sort((a, b) => a - b);
        for (let i = 0; i < ys.length; i++) {
            for (let j = i + 1; j < ys.length; j++) {
                const yLo = ys[i], yHi = ys[j];
                const key = `${yRankMap.get(yLo)},${yRankMap.get(yHi)}`;
                if (pairToX.has(key)) {
                    const prevX = pairToX.get(key);
                    const cnt = rangeQuery(yRankMap.get(yLo), yRankMap.get(yHi));
                    if (cnt === 2) {
                        const area = BigInt(prevX - x) * BigInt(yHi - yLo);
                        if (area > maxArea) maxArea = area;
                    }
                }
                pairToX.set(key, x);
            }
        }
        for (const y of ys) update(yRankMap.get(y));
    }
    return maxArea === -1n ? -1 : Number(maxArea);
};
