// https://leetcode.com/problems/find-the-array-concatenation-value/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long result = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int pow = 1;
            int right = nums[r];
            while (right > 0) {
                pow *= 10;
                right /= 10;
            }
            result += (long) nums[l] * pow + nums[r];
            l++;
            r--;
        }
        if (l == r) {
            result += nums[l];
        }
        return result;
    }
}
