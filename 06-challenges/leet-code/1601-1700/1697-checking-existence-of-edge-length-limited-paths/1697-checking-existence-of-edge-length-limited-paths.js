// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

var distanceLimitedPathsExist = function(n, edgeList, queries) {
    const parent = Array.from({ length: n }, (_, i) => i);
    const rank = new Array(n).fill(0);

    function find(x) {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    function union(x, y) {
        let px = find(x), py = find(y);
        if (px === py) {
            return;
        }
        if (rank[px] < rank[py]) {
            [px, py] = [py, px];
        }
        parent[py] = px;
        if (rank[px] === rank[py]) {
            rank[px]++;
        }
    }

    edgeList.sort((a, b) => a[2] - b[2]);
    const q = queries.length;
    const sortedQ = Array.from({ length: q }, (_, i) => i).sort((a, b) => queries[a][2] - queries[b][2]);
    const result = new Array(q).fill(false);
    let ei = 0;
    for (const qi of sortedQ) {
        const limit = queries[qi][2];
        while (ei < edgeList.length && edgeList[ei][2] < limit) {
            union(edgeList[ei][0], edgeList[ei][1]);
            ei++;
        }
        result[qi] = find(queries[qi][0]) === find(queries[qi][1]);
    }
    return result;
};
