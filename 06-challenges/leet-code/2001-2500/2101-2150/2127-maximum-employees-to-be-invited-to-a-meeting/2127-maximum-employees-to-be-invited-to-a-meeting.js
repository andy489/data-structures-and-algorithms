// https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/
var maximumInvitations = function(favorite) {
    const n = favorite.length;
    const inDegree = new Array(n).fill(0);
    const reverseGraph = Array.from({ length: n }, () => []);
    for (let i = 0; i < n; i++) {
        inDegree[favorite[i]]++;
        reverseGraph[favorite[i]].push(i);
    }

    // Topological sort: mark non-cycle nodes
    const queue = [];
    for (let i = 0; i < n; i++) {
        if (inDegree[i] === 0) queue.push(i);
    }
    const onCycle = new Array(n).fill(true);
    let head = 0;
    while (head < queue.length) {
        const node = queue[head++];
        onCycle[node] = false;
        const nxt = favorite[node];
        if (--inDegree[nxt] === 0) queue.push(nxt);
    }

    function bfsDepth(start, exclude) {
        const q = [[start, 1]];
        let maxD = 1, h = 0;
        while (h < q.length) {
            const [node, d] = q[h++];
            if (d > maxD) maxD = d;
            for (const prev of reverseGraph[node]) {
                if (prev !== exclude && !onCycle[prev]) {
                    q.push([prev, d + 1]);
                }
            }
        }
        return maxD;
    }

    const visited = new Array(n).fill(false);
    let maxCycle = 0, sumChains = 0;

    for (let i = 0; i < n; i++) {
        if (onCycle[i] && !visited[i]) {
            let cur = i, cycleLen = 0;
            const nodes = [];
            while (!visited[cur]) {
                visited[cur] = true;
                nodes.push(cur);
                cur = favorite[cur];
                cycleLen++;
            }
            if (cycleLen === 2) {
                const [a, b] = nodes;
                sumChains += bfsDepth(a, b) + bfsDepth(b, a);
            } else {
                maxCycle = Math.max(maxCycle, cycleLen);
            }
        }
    }
    return Math.max(maxCycle, sumChains);
};
