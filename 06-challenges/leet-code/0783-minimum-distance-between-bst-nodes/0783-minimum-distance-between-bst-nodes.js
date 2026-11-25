// https://leetcode.com/problems/minimum-distance-between-bst-nodes/

var minDiffInBST = function(root) {
    let minDiff = Infinity, prev = null;
    function inorder(node) {
        if (!node) return;
        inorder(node.left);
        if (prev !== null) minDiff = Math.min(minDiff, node.val - prev);
        prev = node.val;
        inorder(node.right);
    }
    inorder(root);
    return minDiff;
};
