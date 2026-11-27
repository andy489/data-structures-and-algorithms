// https://leetcode.com/problems/count-partitions-with-even-sum-difference/
class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return 0;
        }
        return nums.length - 1;
    }
}
