// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// Solution: Recursive Post-order — O(n) time, O(H) space
var lowestCommonAncestor = function(root, p, q) {
    if (!root || root === p || root === q) return root;
    const left = lowestCommonAncestor(root.left, p, q);
    const right = lowestCommonAncestor(root.right, p, q);
    if (left && right) return root;
    return left || right;
};
