// https://leetcode.com/problems/find-duplicate-subtrees/

// Solution: Serialize + HashMap — O(n²) time, O(n²) space
class Solution {
    private Map<String, Integer> seen = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String key = serialize(node.left) + "," + serialize(node.right) + "," + node.val;
        seen.merge(key, 1, Integer::sum);
        if (seen.get(key) == 2) {
            result.add(node);
        }
        return key;
    }
}
