// https://leetcode.com/problems/count-number-of-possible-root-nodes/

/**
 * @param {number[][]} edges
 * @param {number[][]} guesses
 * @param {number} k
 * @return {number}
 */
var rootCount = function(edges, guesses, k) {
    const n = edges.length + 1;
    const adj = Array.from({length: n}, () => []);
    for (const [u, v] of edges) {
        adj[u].push(v);
        adj[v].push(u);
    }

    const guessSet = new Set(guesses.map(([u, v]) => u * 100001 + v));
    let result = 0;

    function dfs1(node, parent) {
        let cnt = 0;
        for (const child of adj[node]) {
            if (child === parent) continue;
            if (guessSet.has(node * 100001 + child)) cnt++;
            cnt += dfs1(child, node);
        }
        return cnt;
    }

    const correct0 = dfs1(0, -1);

    function dfs2(node, parent, cur) {
        if (cur >= k) result++;
        for (const child of adj[node]) {
            if (child === parent) continue;
            let nxt = cur;
            if (guessSet.has(node * 100001 + child)) nxt--;
            if (guessSet.has(child * 100001 + node)) nxt++;
            dfs2(child, node, nxt);
        }
    }

    dfs2(0, -1, correct0);
    return result;
};
