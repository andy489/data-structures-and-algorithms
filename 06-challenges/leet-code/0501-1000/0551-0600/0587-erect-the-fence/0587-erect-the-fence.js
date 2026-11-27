// https://leetcode.com/problems/erect-the-fence/
var outerTrees = function(trees) {
    const cross = (O, A, B) =>
        (A[0] - O[0]) * (B[1] - O[1]) - (A[1] - O[1]) * (B[0] - O[0]);
    trees.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]);
    const hull = [];
    for (const p of trees) {
        while (hull.length >= 2 && cross(hull[hull.length-2], hull[hull.length-1], p) < 0) {
            hull.pop();
        }
        hull.push(p);
    }
    const upper = [];
    for (let i = trees.length - 1; i >= 0; i--) {
        const p = trees[i];
        while (upper.length >= 2 && cross(upper[upper.length-2], upper[upper.length-1], p) < 0) {
            upper.pop();
        }
        upper.push(p);
    }
    const onHull = new Set([...hull, ...upper].map(p => p.toString()));
    return [...hull, ...upper].filter(p => {
        const key = p.toString();
        if (onHull.has(key)) {
            onHull.delete(key);
            return true;
        }
        return false;
    });
};
