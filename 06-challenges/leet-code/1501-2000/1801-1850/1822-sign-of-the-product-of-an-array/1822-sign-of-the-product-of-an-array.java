// https://leetcode.com/problems/sign-of-the-product-of-an-array/

// Solution: Count Negatives — O(n) time, O(1) space
class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int x : nums) {
            if (x == 0) return 0;
            if (x < 0) sign = -sign;
        }
        return sign;
    }
}
