// https://leetcode.com/problems/all-paths-from-source-to-target/

var allPathsSourceTarget = function(graph) {
    const result = [];
    const n = graph.length - 1;
    function dfs(node, path) {
        if (node === n) { result.push([...path]); return; }
        for (const nxt of graph[node]) {
            path.push(nxt);
            dfs(nxt, path);
            path.pop();
        }
    }
    dfs(0, [0]);
    return result;
};
