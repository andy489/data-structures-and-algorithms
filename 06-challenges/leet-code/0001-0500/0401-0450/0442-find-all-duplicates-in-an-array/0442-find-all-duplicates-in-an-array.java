// https://leetcode.com/problems/find-all-duplicates-in-an-array/

// Solution: Index Negation — O(n) time, O(1) space
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                duplicates.add(idx + 1);
            } else {
                nums[idx] = -nums[idx];
            }
        }
        return duplicates;
    }
}
