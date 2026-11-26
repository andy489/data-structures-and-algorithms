// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

var maxNumEdgesToRemove = function(n, edges) {
    const parentA = Array.from({length: n + 1}, (_, i) => i);
    const parentB = Array.from({length: n + 1}, (_, i) => i);
    const rankA = new Array(n + 1).fill(0);
    const rankB = new Array(n + 1).fill(0);

    const find = (parent, x) => {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    const union = (parent, rank, a, b) => {
        const ra = find(parent, a), rb = find(parent, b);
        if (ra === rb) {
            return false;
        }
        if (rank[ra] < rank[rb]) {
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    };

    let removed = 0, connA = n, connB = n;

    for (const [t, u, v] of edges) {
        if (t === 3) {
            const ua = union(parentA, rankA, u, v);
            const ub = union(parentB, rankB, u, v);
            if (ua) {
                connA--;
            }
            if (ub) {
                connB--;
            }
            if (!ua && !ub) {
                removed++;
            }
        }
    }

    for (const [t, u, v] of edges) {
        if (t === 1) {
            if (!union(parentA, rankA, u, v)) {
                removed++;
            } else {
                connA--;
            }
        } else if (t === 2) {
            if (!union(parentB, rankB, u, v)) {
                removed++;
            } else {
                connB--;
            }
        }
    }

    return connA === 1 && connB === 1 ? removed : -1;
};
