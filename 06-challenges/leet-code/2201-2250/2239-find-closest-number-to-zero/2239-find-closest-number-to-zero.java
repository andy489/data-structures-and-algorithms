// https://leetcode.com/problems/find-closest-number-to-zero/

class Solution {
    public int findClosestNumber(int[] nums) {
        int best = nums[0];
        for (int x : nums) {
            if (Math.abs(x) < Math.abs(best) || (Math.abs(x) == Math.abs(best) && x > best)) {
                best = x;
            }
        }
        return best;
    }
}
