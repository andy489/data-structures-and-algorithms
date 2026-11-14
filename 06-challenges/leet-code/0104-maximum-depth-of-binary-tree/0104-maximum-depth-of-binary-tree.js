// https://leetcode.com/problems/maximum-depth-of-binary-tree/

var maxDepth = function(root) {
    if (!root) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
};
