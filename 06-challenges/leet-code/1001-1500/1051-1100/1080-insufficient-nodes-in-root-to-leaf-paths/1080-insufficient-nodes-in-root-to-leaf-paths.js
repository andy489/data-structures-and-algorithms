// https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/

var sufficientSubset = function(root, limit) {
    if (!root) return null;
    if (!root.left && !root.right) return root.val < limit ? null : root;
    root.left = sufficientSubset(root.left, limit - root.val);
    root.right = sufficientSubset(root.right, limit - root.val);
    return root.left || root.right ? root : null;
};
