// https://leetcode.com/problems/binary-tree-paths/

// Solution: DFS Recursive — O(n) time, O(h) space
var binaryTreePaths = function(root) {
    const res = [];
    function dfs(node, path) {
        if (!node) return;
        path += node.val;
        if (!node.left && !node.right) {
            res.push(path);
        } else {
            path += '->';
            dfs(node.left, path);
            dfs(node.right, path);
        }
    }
    dfs(root, '');
    return res;
};
