// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Solution 1: Post-order Recursion — O(n) time, O(h) space
var flatten = function(root) {
    if (!root || (!root.left && !root.right)) {
        return;
    }
    flatten(root.left);
    flatten(root.right);
    const right = root.right;
    root.right = root.left;
    root.left = null;
    let tail = root;
    while (tail.right) {
        tail = tail.right;
    }
    tail.right = right;
};

// Solution 2: Morris-like In-place — O(n) time, O(1) space
var flatten2 = function(root) {
    let curr = root;
    while (curr) {
        if (curr.left) {
            let pred = curr.left;
            while (pred.right) {
                pred = pred.right;
            }
            pred.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
        }
        curr = curr.right;
    }
};

// Solution 3: Explicit Stack (Iterative Pre-order) — O(n) time, O(h) space
var flatten3 = function(root) {
    if (!root) {
        return;
    }
    const stack = [root];
    let prev = null;
    while (stack.length > 0) {
        const curr = stack.pop();
        if (prev) {
            prev.right = curr;
            prev.left = null;
        }
        if (curr.right) {
            stack.push(curr.right);
        }
        if (curr.left) {
            stack.push(curr.left);
        }
        prev = curr;
    }
    prev.left = null;
};
