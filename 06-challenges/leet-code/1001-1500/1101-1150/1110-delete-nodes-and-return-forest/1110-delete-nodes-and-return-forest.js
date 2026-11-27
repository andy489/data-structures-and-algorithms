// https://leetcode.com/problems/delete-nodes-and-return-forest/

// Solution: Post-order DFS — O(n) time, O(n + d) space
var delNodes = function(root, to_delete) {
    const deleteSet = new Set(to_delete);
    const result = [];

    function dfs(node, isRoot) {
        if (node === null) { return null; }
        const deleted = deleteSet.has(node.val);
        if (!deleted && isRoot) {
            result.push(node);
        }
        node.left = dfs(node.left, deleted);
        node.right = dfs(node.right, deleted);
        return deleted ? null : node;
    }

    dfs(root, true);
    return result;
};
