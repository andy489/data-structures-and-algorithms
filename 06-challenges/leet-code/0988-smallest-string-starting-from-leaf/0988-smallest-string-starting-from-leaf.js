// https://leetcode.com/problems/smallest-string-starting-from-leaf/

var smallestFromLeaf = function(root) {
    let ans = null;
    const dfs = (node, path) => {
        if (!node) return;
        path.push(String.fromCharCode(97 + node.val));
        if (!node.left && !node.right) {
            const s = path.slice().reverse().join('');
            if (ans === null || s < ans) ans = s;
        } else {
            dfs(node.left, path);
            dfs(node.right, path);
        }
        path.pop();
    };
    dfs(root, []);
    return ans;
};
