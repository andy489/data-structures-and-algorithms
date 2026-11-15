// https://leetcode.com/problems/balanced-binary-tree/

var isBalanced = function(root) {
    return height(root) !== -1;
};

function height(node) {
    if (!node) return 0;
    const lh = height(node.left);
    if (lh === -1) return -1;
    const rh = height(node.right);
    if (rh === -1) return -1;
    if (Math.abs(lh - rh) > 1) return -1;
    return Math.max(lh, rh) + 1;
}

var isBalanced2 = function(root) {
    if (!root) return true;
    const lh = getHeight(root.left);
    const rh = getHeight(root.right);
    return Math.abs(lh - rh) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
};

function getHeight(node) {
    if (!node) return 0;
    return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
}

var isBalanced3 = function(root) {
    if (!root) return true;
    const heights = new Map();
    const stack = [];
    let prev = null, cur = root;
    while (cur || stack.length) {
        while (cur) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack[stack.length - 1];
        if (!cur.right || cur.right === prev) {
            stack.pop();
            const lh = heights.get(cur.left) ?? 0;
            const rh = heights.get(cur.right) ?? 0;
            if (Math.abs(lh - rh) > 1) return false;
            heights.set(cur, Math.max(lh, rh) + 1);
            prev = cur;
            cur = null;
        } else {
            cur = cur.right;
        }
    }
    return true;
};
