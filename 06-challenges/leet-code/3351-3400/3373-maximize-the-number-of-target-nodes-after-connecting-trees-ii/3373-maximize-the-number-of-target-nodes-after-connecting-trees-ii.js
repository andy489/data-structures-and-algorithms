// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/

var maxTargetNodes = function(edges1, edges2) {
    function buildAdj(edges, size) {
        const adj = Array.from({length: size}, () => []);
        for (const [u, v] of edges) {
            adj[u].push(v);
            adj[v].push(u);
        }
        return adj;
    }

    function colorTree(adj) {
        const size = adj.length;
        const color = new Int8Array(size).fill(-1);
        color[0] = 0;
        const queue = [0];
        let head = 0;
        while (head < queue.length) {
            const v = queue[head++];
            for (const nb of adj[v]) {
                if (color[nb] === -1) {
                    color[nb] = 1 - color[v];
                    queue.push(nb);
                }
            }
        }
        return color;
    }

    const n = edges1.length + 1;
    const m = edges2.length + 1;
    const adj1 = buildAdj(edges1, n);
    const adj2 = buildAdj(edges2, m);

    const color1 = colorTree(adj1);
    const color2 = colorTree(adj2);

    const c1 = [0, 0], c2 = [0, 0];
    for (const c of color1) { c1[c]++; }
    for (const c of color2) { c2[c]++; }
    const best2 = Math.max(c2[0], c2[1]);

    return Array.from({length: n}, (_, i) => c1[color1[i]] + best2);
};
