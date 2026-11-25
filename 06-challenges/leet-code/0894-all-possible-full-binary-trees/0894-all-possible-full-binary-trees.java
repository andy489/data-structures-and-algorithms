// https://leetcode.com/problems/all-possible-full-binary-trees/

// Solution: Recursion with Memoization — O(2^n) time, O(2^n) space
class Solution {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n)) { return memo.get(n); }
        List<TreeNode> result = new ArrayList<>();
        if (n == 1) {
            result.add(new TreeNode(0));
        } else if (n % 2 == 1) {
            for (int L = 1; L < n; L += 2) {
                for (TreeNode left : allPossibleFBT(L)) {
                    for (TreeNode right : allPossibleFBT(n - 1 - L)) {
                        TreeNode root = new TreeNode(0, left, right);
                        result.add(root);
                    }
                }
            }
        }
        memo.put(n, result);
        return result;
    }
}
