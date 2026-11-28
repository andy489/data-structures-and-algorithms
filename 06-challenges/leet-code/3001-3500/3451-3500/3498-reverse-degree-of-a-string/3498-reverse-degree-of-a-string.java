// https://leetcode.com/problems/reverse-degree-of-a-string/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public long reverseDegree(String s) {
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            int reverseVal = 26 - (s.charAt(i) - 'a');
            result += (long) (i + 1) * reverseVal;
        }
        return result;
    }
}
