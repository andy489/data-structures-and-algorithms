// https://leetcode.com/problems/print-binary-tree/

var printTree = function(root) {
    function height(node) {
        if (!node) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    const h = height(root);
    const cols = (1 << (h + 1)) - 1;
    const res = Array.from({length: h + 1}, () => Array(cols).fill(""));

    function fill(node, row, col) {
        if (!node) return;
        res[row][col] = String(node.val);
        const offset = 1 << (h - row - 1);
        fill(node.left, row + 1, col - offset);
        fill(node.right, row + 1, col + offset);
    }

    fill(root, 0, (cols - 1) >> 1);
    return res;
};
