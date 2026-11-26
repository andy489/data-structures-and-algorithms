// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

var levelOrderBottom = function(root) {
    const result = [];
    if (!root) return result;
    const queue = [root];
    while (queue.length) {
        const size = queue.length;
        const level = [];
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            level.push(node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        result.unshift(level);
    }
    return result;
};

var levelOrderBottom2 = function(root) {
    const result = [];

    function dfs(node, depth) {
        if (!node) return;
        if (result.length === depth) result.push([]);
        result[depth].push(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    dfs(root, 0);
    return result.reverse();
};
