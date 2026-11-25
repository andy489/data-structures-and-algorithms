// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

var sumRootToLeaf = function(root) {
    const dfs = (node, cur) => {
        if (!node) return 0;
        cur = cur * 2 + node.val;
        if (!node.left && !node.right) return cur;
        return dfs(node.left, cur) + dfs(node.right, cur);
    };
    return dfs(root, 0);
};
