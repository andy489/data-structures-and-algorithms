// https://leetcode.com/problems/path-sum-iii/

var pathSum = function(root, targetSum) {
    const prefixCounts = new Map([[0, 1]]);

    function dfs(node, currentSum) {
        if (!node) return 0;
        currentSum += node.val;
        let count = prefixCounts.get(currentSum - targetSum) || 0;
        prefixCounts.set(currentSum, (prefixCounts.get(currentSum) || 0) + 1);
        count += dfs(node.left, currentSum);
        count += dfs(node.right, currentSum);
        prefixCounts.set(currentSum, prefixCounts.get(currentSum) - 1);
        return count;
    }

    return dfs(root, 0);
};
