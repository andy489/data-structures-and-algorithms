// https://leetcode.com/problems/sum-of-left-leaves/

var sumOfLeftLeaves = function(root) {
    function dfs(node, isLeft) {
        if (!node) return 0;
        if (!node.left && !node.right) return isLeft ? node.val : 0;
        return dfs(node.left, true) + dfs(node.right, false);
    }
    return dfs(root, false);
};
