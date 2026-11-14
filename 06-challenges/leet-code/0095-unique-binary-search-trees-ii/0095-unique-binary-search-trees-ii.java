// https://leetcode.com/problems/unique-binary-search-trees-ii/

// Solution: Divide and Conquer (Recursion) — O(Cₙ·n) time, O(Cₙ·n) space
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        if (lo > hi) {
            result.add(null);
            return result;
        }
        for (int i = lo; i <= hi; i++) {
            for (TreeNode left : generate(lo, i - 1)) {
                for (TreeNode right : generate(i + 1, hi)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}

// Solution 2: Memoized Recursion — O(Cₙ·n) time, O(Cₙ·n) space
class Solution2 {
    private Map<String, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int lo, int hi) {
        String key = lo + "," + hi;
        if (memo.containsKey(key)) return memo.get(key);
        List<TreeNode> result = new ArrayList<>();
        if (lo > hi) {
            result.add(null);
            return result;
        }
        for (int i = lo; i <= hi; i++) {
            for (TreeNode left : generate(lo, i - 1)) {
                for (TreeNode right : generate(i + 1, hi)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        memo.put(key, result);
        return result;
    }
}
