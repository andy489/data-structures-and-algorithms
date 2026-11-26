// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

var getMinimumDifference = function(root) {
    let minDiff = Infinity;
    let prev = null;

    function inorder(node) {
        if (!node) { return; }
        inorder(node.left);
        if (prev !== null) { minDiff = Math.min(minDiff, node.val - prev); }
        prev = node.val;
        inorder(node.right);
    }

    inorder(root);
    return minDiff;
};
