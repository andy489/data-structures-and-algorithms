// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

var zigzagLevelOrder = function(root) {
    if (!root) return [];
    const result = [];
    const queue = [root];
    let leftToRight = true;
    while (queue.length) {
        const size = queue.length, level = [];
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            level.push(node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        result.push(leftToRight ? level : level.reverse());
        leftToRight = !leftToRight;
    }
    return result;
};
