// https://leetcode.com/problems/maximum-points-activated-with-one-addition/

/**
 * @param {number[][]} points
 * @return {number}
 */
var maxActivated = function(points) {
    const n = points.length;
    const parent = Array.from({length: n}, (_, i) => i);
    const size = new Array(n).fill(1);

    function find(x) {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    function union(a, b) {
        const ra = find(a), rb = find(b);
        if (ra === rb) { return; }
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
        }
    }

    const byX = new Map(), byY = new Map();
    for (let i = 0; i < n; i++) {
        const [x, y] = points[i];
        if (!byX.has(x)) { byX.set(x, []); }
        byX.get(x).push(i);
        if (!byY.has(y)) { byY.set(y, []); }
        byY.get(y).push(i);
    }

    for (const group of byX.values()) {
        for (let i = 1; i < group.length; i++) { union(group[0], group[i]); }
    }
    for (const group of byY.values()) {
        for (let i = 1; i < group.length; i++) { union(group[0], group[i]); }
    }

    const compX = new Map(), compY = new Map();
    for (let i = 0; i < n; i++) {
        const r = find(i);
        if (!compX.has(r)) { compX.set(r, new Set()); }
        if (!compY.has(r)) { compY.set(r, new Set()); }
        compX.get(r).add(points[i][0]);
        compY.get(r).add(points[i][1]);
    }

    const existing = new Set(points.map(([x, y]) => `${x},${y}`));
    const roots = [...compX.keys()];
    const m = roots.length;
    let ans = 1;

    for (const r of roots) {
        ans = Math.max(ans, size[r] + 1);
    }

    for (let i = 0; i < m; i++) {
        for (let j = i + 1; j < m; j++) {
            const r1 = roots[i], r2 = roots[j];
            let canBridge = false;
            outer: for (const x of compX.get(r1)) {
                for (const y of compY.get(r2)) {
                    if (!existing.has(`${x},${y}`)) { canBridge = true; break outer; }
                }
            }
            if (!canBridge) {
                outer2: for (const x of compX.get(r2)) {
                    for (const y of compY.get(r1)) {
                        if (!existing.has(`${x},${y}`)) { canBridge = true; break outer2; }
                    }
                }
            }
            if (canBridge) {
                ans = Math.max(ans, size[r1] + size[r2] + 1);
            }
        }
    }

    return ans;
};
