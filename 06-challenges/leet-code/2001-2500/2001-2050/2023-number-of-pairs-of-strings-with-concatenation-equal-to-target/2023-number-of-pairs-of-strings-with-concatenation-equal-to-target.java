// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

// Solution: Prefix Matching — O(n * L) time, O(n) space
class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (nums[i] + nums[j]).equals(target)) { count++; }
            }
        }
        return count;
    }
}
