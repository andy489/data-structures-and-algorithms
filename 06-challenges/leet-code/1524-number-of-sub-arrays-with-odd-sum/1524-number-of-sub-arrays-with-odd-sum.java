// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

// Solution: Prefix Sum Parity — O(n) time, O(1) space
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        long result = 0;
        int even = 1, odd = 0, prefix = 0;
        for (int x : arr) {
            prefix += x;
            if ((prefix & 1) == 1) { // prefix is odd (LSB set)
                result += even;
                odd++;
            } else {
                result += odd;
                even++;
            }
        }
        return (int) (result % MOD);
    }
}
