// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

var subtreeWithAllDeepest = function(root) {
    function dfs(node) {
        if (!node) return [null, 0];
        const [lNode, lDepth] = dfs(node.left);
        const [rNode, rDepth] = dfs(node.right);
        if (lDepth === rDepth) return [node, lDepth + 1];
        if (lDepth > rDepth) return [lNode, lDepth + 1];
        return [rNode, rDepth + 1];
    }
    return dfs(root)[0];
};
