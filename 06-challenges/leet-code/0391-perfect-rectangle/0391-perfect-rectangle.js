// https://leetcode.com/problems/perfect-rectangle/

// Solution: Area + Corner Set — O(n) time, O(n) space
var isRectangleCover = function(rectangles) {
    const corners = new Set();
    let x1 = Infinity, y1 = Infinity, x2 = -Infinity, y2 = -Infinity;
    let area = 0;
    for (const [rx1, ry1, rx2, ry2] of rectangles) {
        x1 = Math.min(x1, rx1); y1 = Math.min(y1, ry1);
        x2 = Math.max(x2, rx2); y2 = Math.max(y2, ry2);
        area += (rx2 - rx1) * (ry2 - ry1);
        for (const p of [`${rx1},${ry1}`,`${rx1},${ry2}`,`${rx2},${ry1}`,`${rx2},${ry2}`]) {
            if (corners.has(p)) corners.delete(p);
            else corners.add(p);
        }
    }
    if (corners.size !== 4) return false;
    for (const p of [`${x1},${y1}`,`${x1},${y2}`,`${x2},${y1}`,`${x2},${y2}`]) {
        if (!corners.has(p)) return false;
    }
    return area === (x2 - x1) * (y2 - y1);
};
