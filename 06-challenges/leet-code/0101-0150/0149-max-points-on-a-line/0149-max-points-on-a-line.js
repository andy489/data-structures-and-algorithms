// https://leetcode.com/problems/max-points-on-a-line/

// Solution: Slope HashMap per anchor — O(n^2) time, O(n) space
var maxPoints = function(points) {
    const n = points.length;
    if (n <= 2) return n;

    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);

    let result = 2;
    for (let i = 0; i < n; i++) {
        const slopeCount = new Map();
        let localMax = 0;
        for (let j = i + 1; j < n; j++) {
            let dx = points[j][0] - points[i][0];
            let dy = points[j][1] - points[i][1];
            const g = gcd(Math.abs(dx), Math.abs(dy));
            if (g) { dx /= g; dy /= g; }
            if (dx < 0) { dx = -dx; dy = -dy; }
            else if (dx === 0) dy = Math.abs(dy);
            const key = `${dx},${dy}`;
            const cnt = (slopeCount.get(key) || 0) + 1;
            slopeCount.set(key, cnt);
            localMax = Math.max(localMax, cnt);
        }
        result = Math.max(result, localMax + 1);
    }
    return result;
};
