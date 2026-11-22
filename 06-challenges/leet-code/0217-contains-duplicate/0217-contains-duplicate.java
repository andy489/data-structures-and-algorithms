// https://leetcode.com/problems/contains-duplicate/

// Solution: HashSet — O(n) time, O(n) space
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}
