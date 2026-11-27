// https://leetcode.com/problems/minimum-generations-to-target-point/

/**
 * @param {number[][]} points
 * @param {number[]} target
 * @return {number}
 */
var minGenerations = function(points, target) {
    const known = new Set();
    const all = [];
    for (const p of points) {
        const key = p.join(',');
        if (!known.has(key)) {
            known.add(key);
            all.push(p);
        }
    }
    const tKey = target.join(',');
    if (known.has(tKey)) {
        return 0;
    }
    for (let gen = 1; gen <= 1000; gen++) {
        const size = all.length;
        const newPoints = [];
        for (let i = 0; i < size; i++) {
            for (let j = i + 1; j < size; j++) {
                const a = all[i], b = all[j];
                const c = [Math.floor((a[0] + b[0]) / 2), Math.floor((a[1] + b[1]) / 2), Math.floor((a[2] + b[2]) / 2)];
                const cKey = c.join(',');
                if (cKey === tKey) {
                    return gen;
                }
                if (!known.has(cKey)) {
                    known.add(cKey);
                    newPoints.push(c);
                }
            }
        }
        if (newPoints.length === 0) {
            return -1;
        }
        all.push(...newPoints);
    }
    return -1;
};
