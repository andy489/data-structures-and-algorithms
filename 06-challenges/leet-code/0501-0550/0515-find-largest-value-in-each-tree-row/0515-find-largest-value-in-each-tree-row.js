// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

var largestValues = function(root) {
    if (!root) return [];
    const result = [];
    const queue = [root];
    while (queue.length) {
        let levelMax = -Infinity;
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            levelMax = Math.max(levelMax, node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        result.push(levelMax);
    }
    return result;
};
