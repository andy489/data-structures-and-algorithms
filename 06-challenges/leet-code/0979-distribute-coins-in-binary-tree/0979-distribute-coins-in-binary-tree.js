// https://leetcode.com/problems/distribute-coins-in-binary-tree/

var distributeCoins = function(root) {
    let moves = 0;
    const dfs = (node) => {
        if (!node) return 0;
        const left = dfs(node.left), right = dfs(node.right);
        moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    };
    dfs(root);
    return moves;
};
