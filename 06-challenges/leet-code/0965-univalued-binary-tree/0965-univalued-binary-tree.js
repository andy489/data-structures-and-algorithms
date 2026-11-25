// https://leetcode.com/problems/univalued-binary-tree/

var isUnivalTree = function(root) {
    const val = root.val;
    const check = (node) => {
        if (!node) return true;
        if (node.val !== val) return false;
        return check(node.left) && check(node.right);
    };
    return check(root);
};
