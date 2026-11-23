/**
 * @param {TreeNode} root
 * @param {TreeNode} subRoot
 * @return {boolean}
 */
var isSubtree = function (root, subRoot) {
    if (!root) {
        return false;
    }
    if (isSame(root, subRoot)) {
        return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
};

function isSame(p, q) {
    if (!p && !q) {
        return true;
    }
    if (!p || !q) {
        return false;
    }
    return p.val === q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
}
