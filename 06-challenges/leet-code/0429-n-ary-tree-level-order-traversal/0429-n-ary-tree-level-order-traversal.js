// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

var levelOrder = function(root) {
    if (!root) {
        return [];
    }
    const levels = [];
    const queue = [root];

    while (queue.length > 0) {
        const levelSize = queue.length;
        const levelValues = [];
        for (let i = 0; i < levelSize; i++) {
            const node = queue.shift();
            levelValues.push(node.val);
            for (const child of node.children) {
                queue.push(child);
            }
        }
        levels.push(levelValues);
    }
    return levels;
};
