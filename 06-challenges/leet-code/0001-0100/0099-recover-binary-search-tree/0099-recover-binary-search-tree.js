// https://leetcode.com/problems/recover-binary-search-tree/

// Solution: In-order Traversal (Iterative) — O(n) time, O(h) space
var recoverTree = function(root) {
    let first = null, second = null, prev = null;
    const stack = [];
    let curr = root;
    while (curr || stack.length > 0) {
        while (curr) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        if (prev && prev.val > curr.val) {
            if (!first) first = prev;
            second = curr;
        }
        prev = curr;
        curr = curr.right;
    }
    [first.val, second.val] = [second.val, first.val];
};
