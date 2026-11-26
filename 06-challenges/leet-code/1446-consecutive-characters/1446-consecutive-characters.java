// https://leetcode.com/problems/consecutive-characters/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int maxPower(String s) {
        int max = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) max = Math.max(max, ++cur);
            else cur = 1;
        }
        return max;
    }
}
