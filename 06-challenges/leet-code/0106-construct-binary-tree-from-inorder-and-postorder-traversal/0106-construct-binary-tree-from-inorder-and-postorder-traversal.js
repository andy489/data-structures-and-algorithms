// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

var buildTree = function(inorder, postorder) {
    const inorderIndex = new Map();
    inorder.forEach((val, i) => inorderIndex.set(val, i));

    function build(inL, inR, postL, postR) {
        if (inL > inR) return null;
        const root = new TreeNode(postorder[postR]);
        const mid = inorderIndex.get(postorder[postR]);
        const leftSize = mid - inL;
        root.left = build(inL, mid - 1, postL, postL + leftSize - 1);
        root.right = build(mid + 1, inR, postL + leftSize, postR - 1);
        return root;
    }

    return build(0, inorder.length - 1, 0, postorder.length - 1);
};
