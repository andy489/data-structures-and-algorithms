// https://leetcode.com/problems/number-of-changing-keys/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int countKeyChanges(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1))) {
                count++;
            }
        }
        return count;
    }
}
