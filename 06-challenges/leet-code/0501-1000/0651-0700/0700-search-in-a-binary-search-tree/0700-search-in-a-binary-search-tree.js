// https://leetcode.com/problems/search-in-a-binary-search-tree/

var searchBST = function(root, val) {
    while (root) {
        if (root.val === val) return root;
        root = val < root.val ? root.left : root.right;
    }
    return null;
};
