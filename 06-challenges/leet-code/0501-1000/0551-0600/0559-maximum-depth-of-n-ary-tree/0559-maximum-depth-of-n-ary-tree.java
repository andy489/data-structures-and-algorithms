// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
// Solution: DFS — O(n) time, O(h) space
class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int childMax = 0;
        for (Node child : root.children) {
            childMax = Math.max(childMax, maxDepth(child));
        }
        return 1 + childMax;
    }
}
