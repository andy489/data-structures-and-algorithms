// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

var findSecondMinimumValue = function(root) {
    const minVal = root.val;
    let result = Infinity;

    function dfs(node) {
        if (!node) return;
        if (node.val > minVal && node.val < result) {
            result = node.val;
            return;
        }
        dfs(node.left);
        dfs(node.right);
    }

    dfs(root);
    return result === Infinity ? -1 : result;
};
