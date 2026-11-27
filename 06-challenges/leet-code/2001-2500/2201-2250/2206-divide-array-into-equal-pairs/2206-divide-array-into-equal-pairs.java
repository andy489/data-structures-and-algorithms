// https://leetcode.com/problems/divide-array-into-equal-pairs/
class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for (int num : nums) {
            freq[num]++;
        }
        for (int f : freq) {
            if (f % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
