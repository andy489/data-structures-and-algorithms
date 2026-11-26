// https://leetcode.com/problems/circle-and-rectangle-overlapping/

var checkOverlap = function(radius, xCenter, yCenter, x1, y1, x2, y2) {
    const cx = Math.max(x1, Math.min(xCenter, x2));
    const cy = Math.max(y1, Math.min(yCenter, y2));
    return (xCenter - cx) ** 2 + (yCenter - cy) ** 2 <= radius ** 2;
};
