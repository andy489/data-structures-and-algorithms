// https://leetcode.com/problems/find-the-sum-of-encrypted-integers/

// Solution: Digit Manipulation — O(n * D) time, O(1) space
class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int total = 0;
        for (int x : nums) {
            int maxD = 0, len = 0, tmp = x;
            while (tmp > 0) {
                maxD = Math.max(maxD, tmp % 10);
                len++;
                tmp /= 10;
            }
            int enc = 0, base = 1;
            for (int i = 0; i < len; i++) { enc += maxD * base; base *= 10; }
            total += enc;
        }
        return total;
    }
}
