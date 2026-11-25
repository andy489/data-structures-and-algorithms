// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

var findTarget = function(root, k) {
    const seen = new Set();

    function dfs(node) {
        if (!node) return false;
        if (seen.has(k - node.val)) return true;
        seen.add(node.val);
        return dfs(node.left) || dfs(node.right);
    }

    return dfs(root);
};
