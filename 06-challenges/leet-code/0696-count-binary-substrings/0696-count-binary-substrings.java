// https://leetcode.com/problems/count-binary-substrings/

// Solution: Group Count — O(n) time, O(1) space
class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0, prev = 0, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                result += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        result += Math.min(prev, curr);
        return result;
    }
}
