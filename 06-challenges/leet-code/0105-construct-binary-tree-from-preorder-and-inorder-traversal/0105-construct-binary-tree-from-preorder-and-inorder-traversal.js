// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

var buildTree = function(preorder, inorder) {
    const inorderIndex = new Map();
    for (let i = 0; i < inorder.length; i++) {
        inorderIndex.set(inorder[i], i);
    }

    function build(preL, preR, inL, inR) {
        if (preL > preR) return null;
        const rootVal = preorder[preL];
        const mid = inorderIndex.get(rootVal);
        const leftSize = mid - inL;
        const root = new TreeNode(rootVal);
        root.left = build(preL + 1, preL + leftSize, inL, mid - 1);
        root.right = build(preL + leftSize + 1, preR, mid + 1, inR);
        return root;
    }

    return build(0, preorder.length - 1, 0, inorder.length - 1);
};
