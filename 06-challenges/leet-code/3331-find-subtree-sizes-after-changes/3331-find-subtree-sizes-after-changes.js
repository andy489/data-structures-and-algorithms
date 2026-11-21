// https://leetcode.com/problems/find-subtree-sizes-after-changes/

// Solution: DFS + Ancestor Character Stack — O(n) time, O(n) space
var findSubtreeSizes = function(parent, s) {
    const n = parent.length;
    const orig = Array.from({length: n}, () => []);
    for (let i = 1; i < n; i++) orig[parent[i]].push(i);

    const charStack = Array.from({length: 26}, () => []);
    const newParent = [...parent];

    function dfsReparent(x) {
        const c = s.charCodeAt(x) - 97;
        if (x !== 0 && charStack[c].length > 0) newParent[x] = charStack[c][charStack[c].length - 1];
        charStack[c].push(x);
        for (const child of orig[x]) dfsReparent(child);
        charStack[c].pop();
    }

    dfsReparent(0);

    const final = Array.from({length: n}, () => []);
    for (let i = 1; i < n; i++) final[newParent[i]].push(i);

    const ans = new Array(n).fill(0);

    function dfsSize(x) {
        ans[x] = 1;
        for (const child of final[x]) {
            dfsSize(child);
            ans[x] += ans[child];
        }
    }

    dfsSize(0);
    return ans;
};
