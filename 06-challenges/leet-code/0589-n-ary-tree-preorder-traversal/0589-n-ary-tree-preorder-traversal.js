// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
var preorder = function(root) {
    const result = [];
    const dfs = (node) => {
        if (!node) {
            return;
        }
        result.push(node.val);
        for (const child of node.children) {
            dfs(child);
        }
    };
    dfs(root);
    return result;
};
