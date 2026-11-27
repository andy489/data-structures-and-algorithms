// https://leetcode.com/problems/maximum-binary-string-after-change/

// Solution: Greedy Construction — O(n) time, O(n) space
class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        int firstZero = binary.indexOf('0');
        if (firstZero == -1) {
            return binary;
        }
        int zeros = 0;
        for (int i = firstZero; i < n; i++) {
            if (binary.charAt(i) == '0') {
                zeros++;
            }
        }
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = '1';
        }
        result[firstZero + zeros - 1] = '0';
        return new String(result);
    }
}
