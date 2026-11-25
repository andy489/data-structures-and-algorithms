// https://leetcode.com/problems/maximum-binary-tree-ii/

var insertIntoMaxTree = function(root, val) {
    const node = new TreeNode(val);
    if (!root || root.val < val) { node.left = root; return node; }
    let cur = root;
    while (cur.right && cur.right.val > val) cur = cur.right;
    node.left = cur.right;
    cur.right = node;
    return root;
};
