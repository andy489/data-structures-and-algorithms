// https://leetcode.com/problems/sum-root-to-leaf-numbers/

// Solution 1: Recursive DFS — O(n) time, O(h) space
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int curr) {
        if (node == null) return 0;
        curr = curr * 10 + node.val;
        if (node.left == null && node.right == null) return curr;
        return dfs(node.left, curr) + dfs(node.right, curr);
    }
}

// Solution 2: Iterative DFS — O(n) time, O(h) space
class Solution2 {
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        Deque<Object[]> st = new ArrayDeque<>();
        st.push(new Object[]{root, 0});
        while (!st.isEmpty()) {
            Object[] top = st.pop();
            TreeNode node = (TreeNode) top[0];
            int curr = (int) top[1] * 10 + node.val;
            if (node.left == null && node.right == null) {
                ans += curr;
            } else {
                if (node.right != null) st.push(new Object[]{node.right, curr});
                if (node.left != null) st.push(new Object[]{node.left, curr});
            }
        }
        return ans;
    }
}
