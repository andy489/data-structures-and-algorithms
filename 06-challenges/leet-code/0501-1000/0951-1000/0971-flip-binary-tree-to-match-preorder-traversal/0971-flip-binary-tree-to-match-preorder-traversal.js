// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

var flipMatchVoyage = function(root, voyage) {
    const res = [];
    let i = 0, ok = true;
    const dfs = (node) => {
        if (!node || !ok) return;
        if (node.val !== voyage[i++]) { ok = false; return; }
        if (node.left && node.left.val !== voyage[i]) {
            res.push(node.val);
            dfs(node.right); dfs(node.left);
        } else {
            dfs(node.left); dfs(node.right);
        }
    };
    dfs(root);
    return ok ? res : [-1];
};
