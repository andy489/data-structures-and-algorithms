// https://leetcode.com/problems/graph-connectivity-with-threshold/

var areConnected = function(n, threshold, queries) {
    const parent = Array.from({length: n + 1}, (_, i) => i);
    const rank = new Array(n + 1).fill(0);

    function find(x) {
        if (parent[x] !== x) parent[x] = find(parent[x]);
        return parent[x];
    }

    function union(x, y) {
        const px = find(x), py = find(y);
        if (px === py) return;
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    for (let z = threshold + 1; z <= n; z++) {
        for (let m = 2 * z; m <= n; m += z) {
            union(z, m);
        }
    }

    return queries.map(([a, b]) => find(a) === find(b));
};
