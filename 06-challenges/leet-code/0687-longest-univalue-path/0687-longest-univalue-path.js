// https://leetcode.com/problems/longest-univalue-path/

var longestUnivaluePath = function(root) {
    let maxPath = 0;

    function dfs(node) {
        if (!node) return 0;
        const leftArm = dfs(node.left);
        const rightArm = dfs(node.right);
        const left = node.left && node.left.val === node.val ? leftArm + 1 : 0;
        const right = node.right && node.right.val === node.val ? rightArm + 1 : 0;
        maxPath = Math.max(maxPath, left + right);
        return Math.max(left, right);
    }

    dfs(root);
    return maxPath;
};
