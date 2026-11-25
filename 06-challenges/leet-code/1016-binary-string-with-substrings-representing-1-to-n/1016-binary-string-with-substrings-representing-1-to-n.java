// https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/

// Solution: Check only large values — O(|s|²) time, O(log n) space
class Solution {
    public boolean queryString(String s, int n) {
        for (int i = n; i > Math.max(0, n - 2 * s.length()); i--) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
