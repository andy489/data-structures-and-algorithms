// https://leetcode.com/problems/trim-a-binary-search-tree/

var trimBST = function(root, low, high) {
    if (!root) return null;
    if (root.val < low) return trimBST(root.right, low, high);
    if (root.val > high) return trimBST(root.left, low, high);
    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);
    return root;
};
