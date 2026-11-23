// https://leetcode.com/problems/serialize-and-deserialize-bst/

var serialize = function(root) {
    const tokens = [];
    function preorder(node) {
        if (!node) return;
        tokens.push(node.val);
        preorder(node.left);
        preorder(node.right);
    }
    preorder(root);
    return tokens.join(' ');
};

var deserialize = function(data) {
    if (!data) return null;
    const queue = data.split(' ').map(Number);
    let idx = 0;
    function build(minVal, maxVal) {
        if (idx >= queue.length) return null;
        const val = queue[idx];
        if (val <= minVal || val >= maxVal) return null;
        idx++;
        const node = new TreeNode(val);
        node.left = build(minVal, val);
        node.right = build(val, maxVal);
        return node;
    }
    return build(-Infinity, Infinity);
};
