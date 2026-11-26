// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

var goodNodes = function(root) {
    function dfs(node, maxSoFar) {
        if (!node) return 0;
        const count = node.val >= maxSoFar ? 1 : 0;
        const newMax = Math.max(maxSoFar, node.val);
        return count + dfs(node.left, newMax) + dfs(node.right, newMax);
    }
    return dfs(root, -Infinity);
};
