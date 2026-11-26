// https://leetcode.com/problems/sum-root-to-leaf-numbers/

// Solution 1: Recursive DFS — O(n) time, O(h) space
var sumNumbers = function(root) {
    function dfs(node, curr) {
        if (!node) return 0;
        curr = curr * 10 + node.val;
        if (!node.left && !node.right) return curr;
        return dfs(node.left, curr) + dfs(node.right, curr);
    }
    return dfs(root, 0);
};

// Solution 2: Iterative DFS — O(n) time, O(h) space
var sumNumbers2 = function(root) {
    let ans = 0;
    const stack = [[root, 0]];
    while (stack.length > 0) {
        const [node, prev] = stack.pop();
        const curr = prev * 10 + node.val;
        if (!node.left && !node.right) {
            ans += curr;
        } else {
            if (node.right) stack.push([node.right, curr]);
            if (node.left) stack.push([node.left, curr]);
        }
    }
    return ans;
};
