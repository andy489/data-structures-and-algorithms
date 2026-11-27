// https://leetcode.com/problems/increasing-order-search-tree/

var increasingBST = function(root) {
    const dummy = new TreeNode(0);
    let curr = dummy;
    function inorder(node) {
        if (!node) return;
        inorder(node.left);
        node.left = null;
        curr.right = node;
        curr = node;
        inorder(node.right);
    }
    inorder(root);
    return dummy.right;
};
