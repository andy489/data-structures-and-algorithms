// https://leetcode.com/problems/find-bottom-left-tree-value/

var findBottomLeftValue = function(root) {
    const queue = [root];
    let last = root;
    while (queue.length) {
        last = queue.shift();
        if (last.right) queue.push(last.right);
        if (last.left) queue.push(last.left);
    }
    return last.val;
};
