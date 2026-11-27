// https://leetcode.com/problems/binary-tree-level-order-traversal/

var levelOrder = function(root) {
    if (!root) return [];
    const result = [], queue = [root];
    while (queue.length) {
        const size = queue.length, level = [];
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            level.push(node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        result.push(level);
    }
    return result;
};
