// https://leetcode.com/problems/house-robber-iii/

// Solution: DFS with Pair Return — O(n) time, O(n) space
var rob = function(root) {
    function dfs(node) {
        if (!node) return [0, 0];
        const [leftSkip, leftRob] = dfs(node.left);
        const [rightSkip, rightRob] = dfs(node.right);
        const skip = Math.max(leftSkip, leftRob) + Math.max(rightSkip, rightRob);
        const robThis = node.val + leftSkip + rightSkip;
        return [skip, robThis];
    }
    return Math.max(...dfs(root));
};
