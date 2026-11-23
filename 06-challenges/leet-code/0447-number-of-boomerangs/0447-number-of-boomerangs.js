// https://leetcode.com/problems/number-of-boomerangs/

var numberOfBoomerangs = function(points) {
    let result = 0;
    for (const [x1, y1] of points) {
        const distanceCounts = new Map();
        for (const [x2, y2] of points) {
            const squaredDist = (x1 - x2) ** 2 + (y1 - y2) ** 2;
            distanceCounts.set(squaredDist, (distanceCounts.get(squaredDist) || 0) + 1);
        }
        for (const count of distanceCounts.values()) {
            result += count * (count - 1);
        }
    }
    return result;
};
