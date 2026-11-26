// https://leetcode.com/problems/validate-binary-search-tree/

// Solution: Bounded Recursion — O(n) time, O(h) space
var isValidBST = function(root) {
    function validate(node, min, max) {
        if (!node) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
    return validate(root, -Infinity, Infinity);
};
