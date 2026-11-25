// https://leetcode.com/problems/leaf-similar-trees/

// Solution: DFS — O(n) time, O(n) space
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}
