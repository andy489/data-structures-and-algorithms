// https://leetcode.com/problems/binary-tree-coloring-game/

var btreeGameWinningMove = function(root, n, x) {
    let left = 0, right = 0;

    function count(node) {
        if (!node) { return 0; }
        const l = count(node.left);
        const r = count(node.right);
        if (node.val === x) { left = l; right = r; }
        return l + r + 1;
    }

    count(root);
    const parent = n - left - right - 1;
    return Math.max(left, right, parent) > Math.floor(n / 2);
};
