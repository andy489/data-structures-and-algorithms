// https://leetcode.com/problems/binary-tree-right-side-view/

// Solution 1: BFS (level-order) — O(n) time, O(n) space
var rightSideView = function(root) {
    if (!root) return [];
    const res = [];
    const q = [root];
    while (q.length) {
        const size = q.length;
        let last;
        for (let i = 0; i < size; i++) {
            last = q.shift();
            if (last.left) q.push(last.left);
            if (last.right) q.push(last.right);
        }
        res.push(last.val);
    }
    return res;
};

// Solution 2: DFS (right-first preorder) — O(n) time, O(h) space
var rightSideView2 = function(root) {
    const res = [];
    function dfs(node, depth) {
        if (!node) return;
        if (res.length === depth) res.push(node.val);
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
    dfs(root, 0);
    return res;
};
