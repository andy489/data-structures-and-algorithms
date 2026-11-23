// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// Solution: Preorder DFS with Null Markers — O(n) time, O(n) space
var serialize = function(root) {
    const parts = [];
    function dfs(node) {
        if (!node) { parts.push('#'); return; }
        parts.push(node.val);
        dfs(node.left);
        dfs(node.right);
    }
    dfs(root);
    return parts.join(',');
};

var deserialize = function(data) {
    const tokens = data.split(',');
    let i = 0;
    function dfs() {
        const token = tokens[i++];
        if (token === '#') return null;
        const node = new TreeNode(parseInt(token));
        node.left = dfs();
        node.right = dfs();
        return node;
    }
    return dfs();
};
