// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

var lcaDeepestLeaves = function(root) {
    function dfs(node) {
        if (!node) { return [0, null]; }
        const [ld, ll] = dfs(node.left);
        const [rd, rl] = dfs(node.right);
        if (ld === rd) { return [ld + 1, node]; }
        return ld > rd ? [ld + 1, ll] : [rd + 1, rl];
    }
    return dfs(root)[1];
};
