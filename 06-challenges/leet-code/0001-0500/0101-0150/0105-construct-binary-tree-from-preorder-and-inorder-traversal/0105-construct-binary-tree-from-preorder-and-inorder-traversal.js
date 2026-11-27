// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Solution 1: Recursive DFS with HashMap
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

// Solution 2: Iterative with Stack
var buildTree2 = function(preorder, inorder) {
    const root = new TreeNode(preorder[0]);
    const stack = [root];
    let inorderIdx = 0;
    for (let i = 1; i < preorder.length; i++) {
        const node = new TreeNode(preorder[i]);
        if (stack[stack.length - 1].val !== inorder[inorderIdx]) {
            stack[stack.length - 1].left = node;
        } else {
            let parent = null;
            while (stack.length && stack[stack.length - 1].val === inorder[inorderIdx]) {
                parent = stack.pop();
                inorderIdx++;
            }
            parent.right = node;
        }
        stack.push(node);
    }
    return root;
};

