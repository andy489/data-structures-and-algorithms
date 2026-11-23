// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

// Solution: Index Negation — O(n) time, O(1) space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
        }
        return missing;
    }
}
