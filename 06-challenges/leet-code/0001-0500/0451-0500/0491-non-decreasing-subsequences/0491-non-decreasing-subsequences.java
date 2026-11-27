// https://leetcode.com/problems/non-decreasing-subsequences/

// Solution: Backtracking with Level-wise Deduplication — O(2^n · n) time, O(2^n · n) space
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> results) {
        if (current.size() >= 2) {
            results.add(new ArrayList<>(current));
        }
        Set<Integer> usedAtThisLevel = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (usedAtThisLevel.contains(nums[i])) {
                continue;
            }
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                usedAtThisLevel.add(nums[i]);
                current.add(nums[i]);
                backtrack(nums, i + 1, current, results);
                current.remove(current.size() - 1);
            }
        }
    }
}
