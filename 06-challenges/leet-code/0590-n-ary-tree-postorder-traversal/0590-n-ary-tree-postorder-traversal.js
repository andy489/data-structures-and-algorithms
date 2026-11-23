// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
var postorder = function(root) {
    const result = [];
    const dfs = (node) => {
        if (!node) {
            return;
        }
        for (const child of node.children) {
            dfs(child);
        }
        result.push(node.val);
    };
    dfs(root);
    return result;
};
