// https://leetcode.com/problems/binary-tree-cameras/

var minCameraCover = function(root) {
    let cameras = 0;
    const dfs = (node) => {
        if (!node) return 1;
        const left = dfs(node.left), right = dfs(node.right);
        if (left === 0 || right === 0) { cameras++; return 2; }
        if (left === 2 || right === 2) return 1;
        return 0;
    };
    if (dfs(root) === 0) cameras++;
    return cameras;
};
