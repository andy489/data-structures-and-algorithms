// https://leetcode.com/problems/path-sum-ii/

var pathSum = function(root, targetSum) {
    const result = [];
    function dfs(node, remaining, path) {
        if (!node) return;
        path.push(node.val);
        remaining -= node.val;
        if (!node.left && !node.right && remaining === 0) result.push([...path]);
        dfs(node.left,  remaining, path);
        dfs(node.right, remaining, path);
        path.pop();
    }
    dfs(root, targetSum, []);
    return result;
};

var pathSum2 = function(root, targetSum) {
    if (!root) return [];
    const result = [];
    const stack = [[root, targetSum - root.val, [root.val]]];
    while (stack.length) {
        const [node, remaining, path] = stack.pop();
        if (!node.left && !node.right && remaining === 0) result.push(path);
        for (const child of [node.right, node.left]) {
            if (child) stack.push([child, remaining - child.val, [...path, child.val]]);
        }
    }
    return result;
};
