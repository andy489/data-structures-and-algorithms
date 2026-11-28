// https://leetcode.com/problems/separate-squares-i/

var separateSquares = function(squares) {
    let lo = Infinity, hi = 0;
    for (const [x, y, l] of squares) {
        lo = Math.min(lo, y);
        hi = Math.max(hi, y + l);
    }
    for (let iter = 0; iter < 100; iter++) {
        const mid = (lo + hi) / 2;
        let below = 0, above = 0;
        for (const [x, y, l] of squares) {
            const top = y + l;
            if (mid >= top) {
                below += l * l;
            } else if (mid <= y) {
                above += l * l;
            } else {
                below += (mid - y) * l;
                above += (top - mid) * l;
            }
        }
        if (below < above) {
            lo = mid;
        } else {
            hi = mid;
        }
    }
    return lo;
};
