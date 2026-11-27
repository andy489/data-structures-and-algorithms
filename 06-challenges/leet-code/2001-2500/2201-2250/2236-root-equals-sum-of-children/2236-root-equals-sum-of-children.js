// https://leetcode.com/problems/root-equals-sum-of-children/

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var checkTree = function(root) {
    return root.val === root.left.val + root.right.val;
};
