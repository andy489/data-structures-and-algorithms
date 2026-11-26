// https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/

// Solution: DFS from Node with Value 1 — O(n) time, O(n) space
var smallestMissingValueSubtree = function(parents, nums) {
    const n = parents.length;
    const children = Array.from({length: n}, () => []);
    for (let i = 1; i < n; i++) children[parents[i]].push(i);
    const ans = new Array(n).fill(1);
    const start = nums.indexOf(1);
    if (start === -1) return ans;
    const visited = new Set();
    let mex = 1;
    const dfs = (node, skip) => {
        visited.add(nums[node]);
        for (const c of children[node]) { if (c !== skip) dfs(c, -1); }
    };
    let cur = start, prev = -1;
    while (cur !== -1) {
        dfs(cur, prev);
        while (visited.has(mex)) mex++;
        ans[cur] = mex;
        [prev, cur] = [cur, parents[cur]];
    }
    return ans;
};
