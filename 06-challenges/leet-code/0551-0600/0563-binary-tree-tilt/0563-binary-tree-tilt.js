/**
 * @param {TreeNode} root
 * @return {number}
 */
var findTilt = function (root) {
    let total = 0;
    function subtreeSum(node) {
        if (!node) {
            return 0;
        }
        const left = subtreeSum(node.left);
        const right = subtreeSum(node.right);
        total += Math.abs(left - right);
        return node.val + left + right;
    }
    subtreeSum(root);
    return total;
};
