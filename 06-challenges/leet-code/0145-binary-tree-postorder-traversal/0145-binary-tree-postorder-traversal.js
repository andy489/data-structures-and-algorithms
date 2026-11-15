// https://leetcode.com/problems/binary-tree-postorder-traversal/

var postorderTraversal = function(root) {
    const result = [];
    if (!root) return result;
    const stack = [root];
    while (stack.length) {
        const node = stack.pop();
        result.push(node.val);
        if (node.left)  stack.push(node.left);
        if (node.right) stack.push(node.right);
    }
    result.reverse();
    return result;
};

var postorderTraversal2 = function(root) {
    const result = [];
    function dfs(node) {
        if (!node) return;
        dfs(node.left);
        dfs(node.right);
        result.push(node.val);
    }
    dfs(root);
    return result;
};

var postorderTraversal3 = function(root) {
    const result = [];
    if (!root) return result;
    const stack = [root], out = [];
    while (stack.length) {
        const node = stack.pop();
        out.push(node);
        if (node.left)  stack.push(node.left);
        if (node.right) stack.push(node.right);
    }
    while (out.length) result.push(out.pop().val);
    return result;
};

var postorderTraversal4 = function(root) {
    const result = [];

    function addReversed(from, to) {
        reverse(from, to);
        let node = to;
        while (true) {
            result.push(node.val);
            if (node === from) break;
            node = node.right;
        }
        reverse(to, from);
    }

    function reverse(from, to) {
        if (from === to) return;
        let prev = from, curr = from.right;
        while (prev !== to) {
            const next = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
    }

    const dummy = { val: 0, left: root, right: null };
    let curr = dummy;
    while (curr) {
        if (!curr.left) {
            curr = curr.right;
        } else {
            let pred = curr.left;
            while (pred.right && pred.right !== curr) pred = pred.right;
            if (!pred.right) {
                pred.right = curr;
                curr = curr.left;
            } else {
                addReversed(curr.left, pred);
                pred.right = null;
                curr = curr.right;
            }
        }
    }
    return result;
};
