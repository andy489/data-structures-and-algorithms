// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
class Solution {
    public int countElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int x : nums) {
            if (x < min) { min = x; }
            if (x > max) { max = x; }
        }
        int count = 0;
        for (int x : nums) {
            if (x > min && x < max) {
                count++;
            }
        }
        return count;
    }
}
