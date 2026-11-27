// https://leetcode.com/problems/tree-of-coprimes/

var getCoprimes = function(nums, edges) {
    const n = nums.length;
    const graph = Array.from({length: n}, () => []);
    for (const [u, v] of edges) {
        graph[u].push(v);
        graph[v].push(u);
    }

    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    const coprimes = {};
    for (let v = 1; v <= 50; v++) {
        coprimes[v] = [];
        for (let w = 1; w <= 50; w++) {
            if (gcd(v, w) === 1) coprimes[v].push(w);
        }
    }

    const ans = new Array(n).fill(-1);
    const last = Array.from({length: 51}, () => []); // last[v] = stack of [node, depth]
    const visited = new Array(n).fill(false);
    const depth = new Array(n).fill(0);
    const stack = [[0, false]];

    while (stack.length > 0) {
        const [u, leaving] = stack.pop();
        if (leaving) {
            last[nums[u]].pop();
            continue;
        }
        if (visited[u]) continue;
        visited[u] = true;
        const d = depth[u];
        let bestDepth = -1, bestNode = -1;
        for (const cp of coprimes[nums[u]]) {
            const stk = last[cp];
            if (stk.length > 0 && stk[stk.length - 1][1] > bestDepth) {
                [bestNode, bestDepth] = stk[stk.length - 1];
            }
        }
        ans[u] = bestNode;
        last[nums[u]].push([u, d]);
        stack.push([u, true]);
        for (const v of graph[u]) {
            if (!visited[v]) {
                depth[v] = d + 1;
                stack.push([v, false]);
            }
        }
    }
    return ans;
};
