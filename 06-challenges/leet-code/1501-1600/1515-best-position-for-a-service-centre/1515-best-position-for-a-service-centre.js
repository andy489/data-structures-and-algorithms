// https://leetcode.com/problems/best-position-for-a-service-centre/

var getMinDistSum = function(positions) {
    const n = positions.length;
    let x = positions.reduce((s, p) => s + p[0], 0) / n;
    let y = positions.reduce((s, p) => s + p[1], 0) / n;

    function totalDist(cx, cy) {
        return positions.reduce((s, p) => s + Math.hypot(cx - p[0], cy - p[1]), 0);
    }

    let step = 1.0;
    while (step > 1e-6) {
        let nx = 0, ny = 0, totalW = 0;
        for (const p of positions) {
            const d = Math.hypot(x - p[0], y - p[1]);
            if (d < 1e-9) continue;
            const w = 1 / d;
            nx += w * p[0];
            ny += w * p[1];
            totalW += w;
        }
        if (totalW < 1e-9) break;
        nx /= totalW;
        ny /= totalW;
        if (totalDist(nx, ny) >= totalDist(x, y)) {
            step *= 0.5;
        } else {
            x = nx;
            y = ny;
        }
    }
    return totalDist(x, y);
};
