// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

var nearestValidPoint = function(x, y, points) {
    let bestDist = Infinity, bestIdx = -1;
    for (let i = 0; i < points.length; i++) {
        const [a, b] = points[i];
        if (a === x || b === y) {
            const dist = Math.abs(x - a) + Math.abs(y - b);
            if (dist < bestDist) {
                bestDist = dist;
                bestIdx = i;
            }
        }
    }
    return bestIdx;
};
