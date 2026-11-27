// https://leetcode.com/problems/check-adjacent-digit-differences/

class Solution {
    public boolean checkAdjacentDifferences(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) > 2) {
                return false;
            }
        }
        return true;
    }
}
