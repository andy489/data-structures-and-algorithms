// https://leetcode.com/problems/same-tree/

var isSameTree = function(p, q) {
    if (p === null && q === null) return true;
    if (p === null || q === null) return false;
    if (p.val !== q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
};

// Solution 2: Iterative BFS — O(n) time, O(n) space
var isSameTree2 = function(p, q) {
    const queue = [[p, q]];
    while (queue.length > 0) {
        const [a, b] = queue.shift();
        if (a === null && b === null) continue;
        if (a === null || b === null) return false;
        if (a.val !== b.val) return false;
        queue.push([a.left, b.left]);
        queue.push([a.right, b.right]);
    }
    return true;
};

// Solution 3: Iterative DFS — O(n) time, O(h) space
var isSameTree3 = function(p, q) {
    const stack = [[p, q]];
    while (stack.length > 0) {
        const [a, b] = stack.pop();
        if (a === null && b === null) continue;
        if (a === null || b === null) return false;
        if (a.val !== b.val) return false;
        stack.push([a.left, b.left]);
        stack.push([a.right, b.right]);
    }
    return true;
};
