// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

var constructFromPrePost = function(preorder, postorder) {
    if (!preorder.length) return null;
    const root = new TreeNode(preorder[0]);
    if (preorder.length === 1) return root;
    const L = postorder.indexOf(preorder[1]) + 1;
    root.left = constructFromPrePost(preorder.slice(1, L + 1), postorder.slice(0, L));
    root.right = constructFromPrePost(preorder.slice(L + 1), postorder.slice(L, -1));
    return root;
};
