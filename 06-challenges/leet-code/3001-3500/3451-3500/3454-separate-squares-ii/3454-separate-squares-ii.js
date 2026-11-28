// https://leetcode.com/problems/separate-squares-ii/

var separateSquares = function(squares) {
    function unionBelow(y) {
        const xSet = new Set();
        for (const [xb, yb, l] of squares) {
            xSet.add(xb);
            xSet.add(xb + l);
        }
        const xs = [...xSet].sort((a, b) => a - b);
        let total = 0;
        for (let i = 0; i + 1 < xs.length; i++) {
            const x1 = xs[i], x2 = xs[i + 1];
            const width = x2 - x1;
            let maxH = 0;
            for (const [xb, yb, l] of squares) {
                if (xb <= x1 && xb + l >= x2) {
                    const bottom = yb, top = yb + l;
                    if (bottom < y) {
                        const clippedTop = Math.min(top, y);
                        maxH = Math.max(maxH, clippedTop - bottom);
                    }
                }
            }
            total += width * maxH;
        }
        return total;
    }

    let lo = Infinity, hi = 0;
    for (const [xb, yb, l] of squares) {
        lo = Math.min(lo, yb);
        hi = Math.max(hi, yb + l);
    }
    const totalArea = unionBelow(hi);

    for (let iter = 0; iter < 100; iter++) {
        const mid = (lo + hi) / 2;
        const below = unionBelow(mid);
        const above = totalArea - below;
        if (below < above) {
            lo = mid;
        } else {
            hi = mid;
        }
    }
    return lo;
};
