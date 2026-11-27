// https://leetcode.com/problems/check-balanced-string/

// Solution: Single Pass Sum — O(n) time, O(1) space
class Solution {
    public boolean isBalanced(String num) {
        int diff = 0;
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            if (i % 2 == 0) {
                diff += d;
            } else {
                diff -= d;
            }
        }
        return diff == 0;
    }
}
