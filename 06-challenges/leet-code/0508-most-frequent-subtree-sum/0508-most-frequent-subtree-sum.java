// https://leetcode.com/problems/most-frequent-subtree-sum/

// Solution: Post-order DFS + HashMap — O(n) time, O(n) space
class Solution {
    private Map<Integer, Integer> sumCount = new HashMap<>();
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int subtreeSum = node.val + dfs(node.left) + dfs(node.right);
        int freq = sumCount.merge(subtreeSum, 1, Integer::sum);
        maxFreq = Math.max(maxFreq, freq);
        return subtreeSum;
    }
}
