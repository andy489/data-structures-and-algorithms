// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

var sumEvenGrandparent = function(root) {
    const dfs = (node, parent, grandparent) => {
        if (!node) return 0;
        const add = grandparent % 2 === 0 ? node.val : 0;
        return add + dfs(node.left, node.val, parent) + dfs(node.right, node.val, parent);
    };
    return dfs(root, 1, 1);
};
