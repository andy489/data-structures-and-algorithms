// https://leetcode.com/problems/swap-adjacent-in-lr-string/

// Solution: Two-Pointer Invariant — O(n) time, O(1) space
class Solution {
    public boolean canTransform(String start, String result) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && result.charAt(j) == 'X') {
                j++;
            }
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n) {
                return false;
            }
            char cs = start.charAt(i), cr = result.charAt(j);
            if (cs != cr) {
                return false;
            }
            if (cs == 'L' && j > i) {
                return false;
            }
            if (cs == 'R' && j < i) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
