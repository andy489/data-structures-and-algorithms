// https://leetcode.com/problems/sum-of-left-leaves/

// Solution: Recursive DFS — O(n) time, O(h) space
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }
        return dfs(node.left, true) + dfs(node.right, false);
    }
}

// Solution2: Iterative DFS — O(n) time, O(n) space
class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        // store node index paired with isLeft flag using object array
        Deque<Object[]> nodeStack = new ArrayDeque<>();
        nodeStack.push(new Object[]{root, false});
        while (!nodeStack.isEmpty()) {
            Object[] entry = nodeStack.pop();
            TreeNode node = (TreeNode) entry[0];
            boolean isLeft = (boolean) entry[1];
            if (node.left == null && node.right == null && isLeft) {
                sum += node.val;
                continue;
            }
            if (node.right != null) {
                nodeStack.push(new Object[]{node.right, false});
            }
            if (node.left != null) {
                nodeStack.push(new Object[]{node.left, true});
            }
        }
        return sum;
    }
}
