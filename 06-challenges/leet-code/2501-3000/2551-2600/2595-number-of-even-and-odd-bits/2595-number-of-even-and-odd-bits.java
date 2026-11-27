// https://leetcode.com/problems/number-of-even-and-odd-bits/
class Solution {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        for (int i = 0; n > 0; i++, n >>= 1) {
            if ((n & 1) == 1) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        return new int[]{even, odd};
    }
}
