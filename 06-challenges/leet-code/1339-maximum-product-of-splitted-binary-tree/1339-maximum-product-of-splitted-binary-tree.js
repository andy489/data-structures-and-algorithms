// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

var maxProduct = function(root) {
    const total = node => node ? node.val + total(node.left) + total(node.right) : 0;
    const t = total(root);
    let best = 0;
    const dfs = node => {
        if (!node) return 0;
        const s = node.val + dfs(node.left) + dfs(node.right);
        best = Math.max(best, s*(t-s));
        return s;
    };
    dfs(root);
    return best % 1_000_000_007;
};
