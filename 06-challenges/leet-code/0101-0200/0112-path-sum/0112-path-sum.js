// https://leetcode.com/problems/path-sum/

var hasPathSum = function(root, targetSum) {
    if (!root) return false;
    targetSum -= root.val;
    if (!root.left && !root.right) return targetSum === 0;
    return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
};

var hasPathSum2 = function(root, targetSum) {
    if (!root) return false;
    const stack = [[root, targetSum - root.val]];
    while (stack.length) {
        const [node, remaining] = stack.pop();
        if (!node.left && !node.right && remaining === 0) return true;
        if (node.right) stack.push([node.right, remaining - node.right.val]);
        if (node.left)  stack.push([node.left,  remaining - node.left.val]);
    }
    return false;
};

var hasPathSum3 = function(root, targetSum) {
    if (!root) return false;
    const queue = [[root, targetSum - root.val]];
    while (queue.length) {
        const [node, remaining] = queue.shift();
        if (!node.left && !node.right && remaining === 0) return true;
        if (node.left)  queue.push([node.left,  remaining - node.left.val]);
        if (node.right) queue.push([node.right, remaining - node.right.val]);
    }
    return false;
};
