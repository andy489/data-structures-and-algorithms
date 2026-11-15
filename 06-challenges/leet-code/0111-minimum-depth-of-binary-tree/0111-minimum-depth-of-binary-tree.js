// https://leetcode.com/problems/minimum-depth-of-binary-tree/

var minDepth = function(root) {
    if (!root) return 0;
    const queue = [root];
    let depth = 0;
    while (queue.length) {
        depth++;
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            if (!node.left && !node.right) return depth;
            if (node.left)  queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
    }
    return depth;
};

var minDepth2 = function(root) {
    if (!root) return 0;
    if (!root.left && !root.right) return 1;
    if (!root.left)  return minDepth2(root.right) + 1;
    if (!root.right) return minDepth2(root.left) + 1;
    return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
};

var minDepth3 = function(root) {
    if (!root) return 0;
    let min = Infinity;
    const stack = [[root, 1]];
    while (stack.length) {
        const [node, depth] = stack.pop();
        if (!node.left && !node.right) min = Math.min(min, depth);
        if (node.right) stack.push([node.right, depth + 1]);
        if (node.left)  stack.push([node.left,  depth + 1]);
    }
    return min;
};

var minDepth4 = function(root) {
    if (!root) return 0;
    let min = Infinity;
    function dfs(node, depth) {
        if (!node.left && !node.right) { min = Math.min(min, depth); return; }
        if (node.left)  dfs(node.left,  depth + 1);
        if (node.right) dfs(node.right, depth + 1);
    }
    dfs(root, 1);
    return min;
};
