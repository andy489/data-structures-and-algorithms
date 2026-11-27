// https://leetcode.com/problems/convert-bst-to-greater-tree/

var convertBST = function(root) {
    let runningSum = 0;

    function reverseInorder(node) {
        if (!node) { return; }
        reverseInorder(node.right);
        runningSum += node.val;
        node.val = runningSum;
        reverseInorder(node.left);
    }

    reverseInorder(root);
    return root;
};
