// https://leetcode.com/problems/largest-triangle-area/

var largestTriangleArea = function(points) {
    const n = points.length;
    let max = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            for (let k = j + 1; k < n; k++) {
                const [ax, ay] = points[i], [bx, by] = points[j], [cx, cy] = points[k];
                max = Math.max(max, 0.5 * Math.abs(ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)));
            }
        }
    }
    return max;
};
