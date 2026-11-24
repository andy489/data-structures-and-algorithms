// https://leetcode.com/problems/set-mismatch/

// Solution: Frequency Count — O(n) time, O(n) space
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for (int num : nums) {
            freq[num]++;
        }
        int duplicate = 0, missing = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (freq[i] == 2) {
                duplicate = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}
