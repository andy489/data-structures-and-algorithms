// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Solution 1: BFS (level-order) — O(n) time, O(n) space
var connect = function(root) {
    if (!root) return null;
    const q = [root];
    while (q.length) {
        const size = q.length;
        for (let i = 0; i < size; i++) {
            const node = q.shift();
            if (i < size - 1) node.next = q[0];
            if (node.left) q.push(node.left);
            if (node.right) q.push(node.right);
        }
    }
    return root;
};

// Solution 2: O(1)-space using established next pointers — O(n) time, O(1) space
var connect2 = function(root) {
    let leftmost = root;
    while (leftmost && leftmost.left) {
        let head = leftmost;
        while (head) {
            head.left.next = head.right;
            if (head.next) head.right.next = head.next.left;
            head = head.next;
        }
        leftmost = leftmost.left;
    }
    return root;
};

// Solution 3: Recursive — O(n) time, O(log n) space
var connect3 = function(root) {
    if (!root || !root.left) return root;
    root.left.next = root.right;
    if (root.next) root.right.next = root.next.left;
    connect3(root.left);
    connect3(root.right);
    return root;
};
