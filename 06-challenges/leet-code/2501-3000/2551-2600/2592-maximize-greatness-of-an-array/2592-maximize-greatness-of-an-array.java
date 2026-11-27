// https://leetcode.com/problems/maximize-greatness-of-an-array/
class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int p = 0;
        for (int num : nums) {
            if (num > nums[p]) {
                p++;
            }
        }
        return p;
    }
}
