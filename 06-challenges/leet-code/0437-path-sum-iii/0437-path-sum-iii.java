// https://leetcode.com/problems/path-sum-iii/

// Solution: Prefix Sum with HashMap — O(n) time, O(n) space
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixCounts);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixCounts) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        int count = prefixCounts.getOrDefault(currentSum - targetSum, 0);
        prefixCounts.merge(currentSum, 1, Integer::sum);
        count += dfs(node.left, currentSum, targetSum, prefixCounts);
        count += dfs(node.right, currentSum, targetSum, prefixCounts);
        prefixCounts.merge(currentSum, -1, Integer::sum);
        return count;
    }
}

// Solution 2: Brute Force DFS — O(n²) time, O(n) space
class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return countFrom(root, targetSum, 0L)
            + pathSum(root.left, targetSum)
            + pathSum(root.right, targetSum);
    }

    private int countFrom(TreeNode node, int targetSum, long current) {
        if (node == null) {
            return 0;
        }
        current += node.val;
        int count = current == targetSum ? 1 : 0;
        count += countFrom(node.left, targetSum, current);
        count += countFrom(node.right, targetSum, current);
        return count;
    }
}
