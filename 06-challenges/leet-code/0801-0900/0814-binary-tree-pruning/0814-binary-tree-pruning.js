// https://leetcode.com/problems/binary-tree-pruning/

var pruneTree = function(root) {
    if (!root) { return null; }
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.val === 0 && !root.left && !root.right) { return null; }
    return root;
};
