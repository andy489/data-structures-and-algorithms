// https://leetcode.com/problems/rotate-string/

// Solution: Double Concatenation — O(n²) time, O(n) space
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
