// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

var countPairs = function(root, distance) {
    let result = 0;

    function dfs(node) {
        if (!node) return [];
        if (!node.left && !node.right) return [1];
        const left = dfs(node.left);
        const right = dfs(node.right);
        for (const l of left) {
            for (const r of right) {
                if (l + r <= distance) result++;
            }
        }
        return [...left, ...right].map(d => d + 1).filter(d => d <= distance);
    }

    dfs(root);
    return result;
};
