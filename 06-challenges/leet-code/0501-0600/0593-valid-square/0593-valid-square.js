// https://leetcode.com/problems/valid-square/
var validSquare = function(p1, p2, p3, p4) {
    const sqDist = (a, b) => (a[0]-b[0])**2 + (a[1]-b[1])**2;
    const points = [p1, p2, p3, p4];
    const dists = new Set();
    for (let i = 0; i < 4; i++) {
        for (let j = i + 1; j < 4; j++) {
            const d = sqDist(points[i], points[j]);
            if (d === 0) {
                return false;
            }
            dists.add(d);
        }
    }
    return dists.size === 2;
};
