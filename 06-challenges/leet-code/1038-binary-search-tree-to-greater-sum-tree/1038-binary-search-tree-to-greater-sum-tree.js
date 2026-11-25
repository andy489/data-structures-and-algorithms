// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

var bstToGst = function(root) {
    let sum = 0;
    const dfs = node => {
        if (!node) return;
        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    };
    dfs(root);
    return root;
};
