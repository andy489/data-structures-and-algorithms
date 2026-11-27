// https://leetcode.com/problems/minimum-swaps-to-move-zeros-to-end/
class Solution {
    public int minimumSwaps(int[] nums) {
        int pos = 0;
        int swaps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > pos) {
                    swaps++;
                }
                pos++;
            }
        }
        return swaps;
    }
}
