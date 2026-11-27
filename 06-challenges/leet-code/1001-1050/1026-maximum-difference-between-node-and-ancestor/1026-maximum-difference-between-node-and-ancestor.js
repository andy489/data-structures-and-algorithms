// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

var maxAncestorDiff = function(root) {
    const dfs = (node, minVal, maxVal) => {
        if (!node) return maxVal - minVal;
        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);
        return Math.max(dfs(node.left, minVal, maxVal), dfs(node.right, minVal, maxVal));
    };
    return dfs(root, root.val, root.val);
};
