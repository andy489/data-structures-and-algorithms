// https://leetcode.com/problems/construct-string-from-binary-tree/

var tree2str = function(root) {
    if (root === null) return "";
    let result = String(root.val);
    if (root.left || root.right) {
        result += "(" + tree2str(root.left) + ")";
    }
    if (root.right) {
        result += "(" + tree2str(root.right) + ")";
    }
    return result;
};
