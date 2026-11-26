// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
// Solution: DFS — O(n) time, O(h) space
var maxDepth = function(root) {
    if (!root) {
        return 0;
    }
    if (root.children.length === 0) {
        return 1;
    }
    return 1 + Math.max(...root.children.map(child => maxDepth(child)));
};
