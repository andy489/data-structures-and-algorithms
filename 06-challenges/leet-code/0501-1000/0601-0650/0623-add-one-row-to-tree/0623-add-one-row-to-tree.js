// https://leetcode.com/problems/add-one-row-to-tree/

var addOneRow = function(root, val, depth) {
    if (depth === 1) {
        const newRoot = new TreeNode(val);
        newRoot.left = root;
        return newRoot;
    }
    const queue = [root];
    let currentDepth = 1;
    while (queue.length > 0) {
        if (currentDepth === depth - 1) {
            for (const node of queue) {
                const newLeft = new TreeNode(val);
                const newRight = new TreeNode(val);
                newLeft.left = node.left;
                newRight.right = node.right;
                node.left = newLeft;
                node.right = newRight;
            }
            break;
        }
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        currentDepth++;
    }
    return root;
};
