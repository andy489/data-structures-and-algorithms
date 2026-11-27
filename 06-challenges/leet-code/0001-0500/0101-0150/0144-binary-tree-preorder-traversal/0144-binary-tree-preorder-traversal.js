// https://leetcode.com/problems/binary-tree-preorder-traversal/

var preorderTraversal = function(root) {
    const result = [];
    if (!root) return result;
    const stack = [root];
    while (stack.length) {
        const node = stack.pop();
        result.push(node.val);
        if (node.right) stack.push(node.right);
        if (node.left)  stack.push(node.left);
    }
    return result;
};

var preorderTraversal2 = function(root) {
    const result = [];
    function dfs(node) {
        if (!node) return;
        result.push(node.val);
        dfs(node.left);
        dfs(node.right);
    }
    dfs(root);
    return result;
};

var preorderTraversal3 = function(root) {
    const result = [];
    let curr = root;
    while (curr) {
        if (!curr.left) {
            result.push(curr.val);
            curr = curr.right;
        } else {
            let pred = curr.left;
            while (pred.right && pred.right !== curr) pred = pred.right;
            if (!pred.right) {
                result.push(curr.val);
                pred.right = curr;
                curr = curr.left;
            } else {
                pred.right = null;
                curr = curr.right;
            }
        }
    }
    return result;
};
