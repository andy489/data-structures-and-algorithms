// https://leetcode.com/problems/shortest-path-with-alternating-colors/

var shortestAlternatingPaths = function(n, redEdges, blueEdges) {
    const graph = Array.from({length: n}, () => []);
    for (const [u, v] of redEdges) { graph[u].push([v, 0]); }
    for (const [u, v] of blueEdges) { graph[u].push([v, 1]); }

    const ans = new Array(n).fill(-1);
    ans[0] = 0;
    const visited = Array.from({length: n}, () => [false, false]);
    visited[0][0] = visited[0][1] = true;

    const queue = [[0, 0, 0], [0, 1, 0]]; // [node, color, dist]
    let head = 0;
    while (head < queue.length) {
        const [node, color, dist] = queue[head++];
        for (const [nb, ec] of graph[node]) {
            if (ec !== color && !visited[nb][ec]) {
                visited[nb][ec] = true;
                if (ans[nb] === -1) { ans[nb] = dist + 1; }
                queue.push([nb, ec, dist + 1]);
            }
        }
    }
    return ans;
};
