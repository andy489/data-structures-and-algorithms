// https://leetcode.com/problems/diameter-of-binary-tree/
// Solution: DFS post-order — O(n) time, O(h) space
var diameterOfBinaryTree = function(root) {
    let maxDiameter = 0;
    function depth(node) {
        if (!node) {
            return 0;
        }
        const leftDepth = depth(node.left);
        const rightDepth = depth(node.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }
    depth(root);
    return maxDiameter;
};
