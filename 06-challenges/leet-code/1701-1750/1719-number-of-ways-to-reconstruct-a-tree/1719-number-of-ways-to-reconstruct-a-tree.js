// https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/

var checkWays = function(pairs) {
    const adj = new Map();
    for (const [x, y] of pairs) {
        if (!adj.has(x)) adj.set(x, new Set());
        if (!adj.has(y)) adj.set(y, new Set());
        adj.get(x).add(y);
        adj.get(y).add(x);
    }

    const n = adj.size;
    const nodes = [...adj.keys()].sort((a, b) => adj.get(a).size - adj.get(b).size);
    let multiple = false;

    for (const u of nodes) {
        const uAdj = adj.get(u);
        const degU = uAdj.size + 1;

        let parent = -1;
        let minDeg = Infinity;
        for (const v of uAdj) {
            const degV = adj.get(v).size + 1;
            if (degV >= degU && degV < minDeg) {
                minDeg = degV;
                parent = v;
            }
        }

        if (parent === -1) {
            if (degU !== n) {
                return 0;
            }
        } else {
            const pAdj = adj.get(parent);
            for (const v of uAdj) {
                if (v !== parent && !pAdj.has(v)) {
                    return 0;
                }
            }
            if (adj.get(parent).size === uAdj.size) {
                multiple = true;
            }
        }
    }
    return multiple ? 2 : 1;
};
