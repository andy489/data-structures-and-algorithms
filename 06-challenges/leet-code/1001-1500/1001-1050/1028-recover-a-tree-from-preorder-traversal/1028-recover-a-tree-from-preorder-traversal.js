// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

var recoverFromPreorder = function(traversal) {
    const stack = [];
    let i = 0;
    while (i < traversal.length) {
        let depth = 0;
        while (i < traversal.length && traversal[i] === '-') { depth++; i++; }
        let val = 0;
        while (i < traversal.length && traversal[i] !== '-') val = val * 10 + Number(traversal[i++]);
        const node = new TreeNode(val);
        while (stack.length > depth) stack.pop();
        if (stack.length) {
            const parent = stack[stack.length - 1];
            if (!parent.left) parent.left = node; else parent.right = node;
        }
        stack.push(node);
    }
    return stack[0];
};
