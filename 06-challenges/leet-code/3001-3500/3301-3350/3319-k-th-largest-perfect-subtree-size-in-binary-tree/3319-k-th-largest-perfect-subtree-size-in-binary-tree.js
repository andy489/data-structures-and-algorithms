// https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthLargestPerfectSubtree = function (root, k) {
    const sizes = [];

    function dfs(node) {
        if (!node) {
            return 0;
        }
        const left = dfs(node.left);
        const right = dfs(node.right);
        if (left === -1 || right === -1 || left !== right) {
            return -1;
        }
        const size = left + right + 1;
        sizes.push(size);
        return size;
    }

    dfs(root);
    sizes.sort((a, b) => b - a);
    return sizes.length >= k ? sizes[k - 1] : -1;
};
