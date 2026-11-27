// https://leetcode.com/problems/last-substring-in-lexicographical-order/

// Solution: Two-Pointer Suffix Comparison — O(n) time, O(1) space
class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;
        while (j + k < n) {
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            } else if (s.charAt(i + k) < s.charAt(j + k)) {
                i = Math.max(i + k + 1, j + 1);
                k = 0;
            } else {
                j = j + k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
