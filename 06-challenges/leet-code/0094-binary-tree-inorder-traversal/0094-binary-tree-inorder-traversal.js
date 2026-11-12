// https://leetcode.com/problems/binary-tree-inorder-traversal/

// Solution: Iterative with explicit stack — O(n) time, O(n) space
var inorderTraversal = function(root) {
    const res = [], stack = [];
    let curr = root;
    while (curr || stack.length) {
        while (curr) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.push(curr.val);
        curr = curr.right;
    }
    return res;
};

// Solution 2: Recursive — O(n) time, O(n) space
var inorderTraversal2 = function(root) {
    const res = [];
    const dfs = (node) => {
        if (!node) return;
        dfs(node.left);
        res.push(node.val);
        dfs(node.right);
    };
    dfs(root);
    return res;
};
