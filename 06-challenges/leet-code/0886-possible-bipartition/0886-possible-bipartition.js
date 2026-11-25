// https://leetcode.com/problems/possible-bipartition/

var possibleBipartition = function(n, dislikes) {
    const graph = Array.from({length: n + 1}, () => []);
    for (const [a, b] of dislikes) { graph[a].push(b); graph[b].push(a); }
    const color = new Array(n + 1).fill(0);
    for (let i = 1; i <= n; i++) {
        if (color[i]) continue;
        const queue = [i];
        color[i] = 1;
        for (let qi = 0; qi < queue.length; qi++) {
            const u = queue[qi];
            for (const v of graph[u]) {
                if (!color[v]) { color[v] = -color[u]; queue.push(v); }
                else if (color[v] === color[u]) return false;
            }
        }
    }
    return true;
};
