// https://leetcode.com/problems/invert-binary-tree/

// Solution: Recursive DFS — O(n) time, O(h) space
var invertTree = function(root) {
    if (!root) return null;
    [root.left, root.right] = [root.right, root.left];
    invertTree(root.left);
    invertTree(root.right);
    return root;
};

// Solution 2: Iterative BFS — O(n) time, O(n) space
var invertTree2 = function(root) {
    if (!root) return null;
    const queue = [root];
    while (queue.length) {
        const node = queue.shift();
        [node.left, node.right] = [node.right, node.left];
        if (node.left) queue.push(node.left);
        if (node.right) queue.push(node.right);
    }
    return root;
};
