// https://leetcode.com/problems/find-mode-in-binary-search-tree/

var findMode = function(root) {
    const modes = [];
    let maxCount = 0, curCount = 0, prev = null;

    function inorder(node) {
        if (!node) return;
        inorder(node.left);
        curCount = node.val === prev ? curCount + 1 : 1;
        if (curCount > maxCount) {
            maxCount = curCount;
            modes.length = 0;
            modes.push(node.val);
        } else if (curCount === maxCount) {
            modes.push(node.val);
        }
        prev = node.val;
        inorder(node.right);
    }

    inorder(root);
    return modes;
};
