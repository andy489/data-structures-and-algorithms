// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

var verticalTraversal = function(root) {
    const nodes = [];
    const dfs = (node, col, row) => {
        if (!node) return;
        nodes.push([col, row, node.val]);
        dfs(node.left, col-1, row+1);
        dfs(node.right, col+1, row+1);
    };
    dfs(root, 0, 0);
    nodes.sort((a, b) => a[0]-b[0] || a[1]-b[1] || a[2]-b[2]);
    const res = [];
    let prev = null;
    for (const [col,,val] of nodes) {
        if (col !== prev) { res.push([]); prev = col; }
        res[res.length-1].push(val);
    }
    return res;
};
