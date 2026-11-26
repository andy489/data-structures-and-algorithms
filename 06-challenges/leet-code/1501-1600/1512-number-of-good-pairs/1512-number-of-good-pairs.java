// https://leetcode.com/problems/number-of-good-pairs/

// Solution: Frequency Count — O(n) time, O(n) space
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int result = 0;
        for (int num : nums) {
            result += count[num];
            count[num]++;
        }
        return result;
    }
}
