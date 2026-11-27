// https://leetcode.com/problems/falling-squares/

var fallingSquares = function(positions) {
    const intervals = [];
    const result = [];
    let globalMax = 0;
    for (const [l, side] of positions) {
        const r = l + side;
        let base = 0;
        for (const [il, ir, ih] of intervals) {
            if (il < r && ir > l) base = Math.max(base, ih);
        }
        const height = base + side;
        intervals.push([l, r, height]);
        globalMax = Math.max(globalMax, height);
        result.push(globalMax);
    }
    return result;
};
