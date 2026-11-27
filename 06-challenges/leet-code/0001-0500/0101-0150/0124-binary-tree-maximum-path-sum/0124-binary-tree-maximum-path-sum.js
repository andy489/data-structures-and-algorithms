// https://leetcode.com/problems/binary-tree-maximum-path-sum/

var maxPathSum = function(root) {
    let ans = -Infinity;

    const dfs = (node) => {
        if (!node) {
            return 0;
        }
        const leftGain = Math.max(0, dfs(node.left));
        const rightGain = Math.max(0, dfs(node.right));
        ans = Math.max(ans, node.val + leftGain + rightGain);
        return node.val + Math.max(leftGain, rightGain);
    };

    dfs(root);
    return ans;
};
