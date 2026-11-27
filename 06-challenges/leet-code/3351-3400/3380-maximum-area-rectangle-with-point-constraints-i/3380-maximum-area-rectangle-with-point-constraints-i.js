// https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-i/

var maxRectangleArea = function(points) {
    const ptSet = new Set(points.map(([x, y]) => `${x},${y}`));
    let maxArea = -1;

    for (let i = 0; i < points.length; i++) {
        for (let j = i + 1; j < points.length; j++) {
            const x1 = Math.min(points[i][0], points[j][0]);
            const x2 = Math.max(points[i][0], points[j][0]);
            const y1 = Math.min(points[i][1], points[j][1]);
            const y2 = Math.max(points[i][1], points[j][1]);
            if (x1 === x2 || y1 === y2) continue;
            // Check all 4 corners exist
            if (!ptSet.has(`${x1},${y1}`) || !ptSet.has(`${x1},${y2}`) ||
                !ptSet.has(`${x2},${y1}`) || !ptSet.has(`${x2},${y2}`)) continue;
            // Check no non-corner point inside or on border
            const corners = new Set([`${x1},${y1}`, `${x1},${y2}`, `${x2},${y1}`, `${x2},${y2}`]);
            let valid = true;
            for (const [px, py] of points) {
                if (px >= x1 && px <= x2 && py >= y1 && py <= y2) {
                    if (!corners.has(`${px},${py}`)) { valid = false; break; }
                }
            }
            if (valid) {
                maxArea = Math.max(maxArea, (x2 - x1) * (y2 - y1));
            }
        }
    }
    return maxArea;
};
