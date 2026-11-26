// https://leetcode.com/problems/delete-leaves-with-a-given-value/

var removeLeafNodes = function(root, target) {
    if (!root) return null;
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    return (!root.left && !root.right && root.val === target) ? null : root;
};
