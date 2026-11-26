// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

var bstFromPreorder = function(preorder) {
    let i = 0;
    function build(bound) {
        if (i === preorder.length || preorder[i] > bound) return null;
        const node = new TreeNode(preorder[i++]);
        node.left = build(node.val);
        node.right = build(bound);
        return node;
    }
    return build(Infinity);
};
