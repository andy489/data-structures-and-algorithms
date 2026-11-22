// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// Solution: Iterative Inorder — O(H+k) time, O(H) space
var kthSmallest = function(root, k) {
    const stack = [];
    let curr = root;
    while (curr || stack.length) {
        while (curr) { stack.push(curr); curr = curr.left; }
        curr = stack.pop();
        if (--k === 0) return curr.val;
        curr = curr.right;
    }
    return -1;
};

// Solution 2: Recursive Inorder with early exit
var kthSmallest2 = function(root, k) {
    let count = k, result = -1;
    function inorder(node) {
        if (!node || count <= 0) return;
        inorder(node.left);
        if (--count === 0) result = node.val;
        inorder(node.right);
    }
    inorder(root);
    return result;
};
