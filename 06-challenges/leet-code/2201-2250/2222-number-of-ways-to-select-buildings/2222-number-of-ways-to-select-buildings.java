// https://leetcode.com/problems/number-of-ways-to-select-buildings/
class Solution {
    public long numberOfWays(String s) {
        long zeros = 0, ones = 0;
        long zeroOne = 0, oneZero = 0;
        long result = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                result += zeroOne;
                oneZero += ones;
                zeros++;
            } else {
                result += oneZero;
                zeroOne += zeros;
                ones++;
            }
        }
        return result;
    }
}
