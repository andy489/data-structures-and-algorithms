// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

// Solution: Count Mismatches — O(n) time, O(1) space
class Solution {
    public int minOperations(String s) {
        int cost0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != i % 2) {
                cost0++;
            }
        }
        return Math.min(cost0, s.length() - cost0);
    }
}
