// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

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

// Solution 2: O(1)-space dummy-head level traversal — O(n) time, O(1) space
var connect2 = function(root) {
    let curr = root;
    while (curr) {
        const dummy = { next: null };
        let tail = dummy;
        while (curr) {
            if (curr.left) { tail.next = curr.left; tail = tail.next; }
            if (curr.right) { tail.next = curr.right; tail = tail.next; }
            curr = curr.next;
        }
        curr = dummy.next;
    }
    return root;
};
