// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// Solution: Iterative BST Navigation — O(H) time, O(1) space
var lowestCommonAncestor = function(root, p, q) {
    while (root) {
        if (p.val < root.val && q.val < root.val) root = root.left;
        else if (p.val > root.val && q.val > root.val) root = root.right;
        else return root;
    }
    return null;
};

// Solution 2: Recursive
var lowestCommonAncestor2 = function(root, p, q) {
    if (p.val < root.val && q.val < root.val) return lowestCommonAncestor2(root.left, p, q);
    if (p.val > root.val && q.val > root.val) return lowestCommonAncestor2(root.right, p, q);
    return root;
};
