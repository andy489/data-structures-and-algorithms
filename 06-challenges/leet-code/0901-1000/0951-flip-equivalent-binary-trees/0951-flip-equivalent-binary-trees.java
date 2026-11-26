// https://leetcode.com/problems/flip-equivalent-binary-trees/

// Solution: Recursive DFS — O(min(n1,n2)) time, O(min(h1,h2)) space
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return noFlip || flip;
    }
}
