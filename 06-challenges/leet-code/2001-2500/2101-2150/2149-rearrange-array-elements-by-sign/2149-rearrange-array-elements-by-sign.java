// https://leetcode.com/problems/rearrange-array-elements-by-sign/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIdx = 0;
        int negIdx = 1;
        for (int x : nums) {
            if (x > 0) {
                result[posIdx] = x;
                posIdx += 2;
            } else {
                result[negIdx] = x;
                negIdx += 2;
            }
        }
        return result;
    }
}
