// https://leetcode.com/problems/valid-palindrome-ii/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public boolean validPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return isPalin(s, lo + 1, hi) || isPalin(s, lo, hi - 1);
            }
            lo++;
            hi--;
        }
        return true;
    }

    private boolean isPalin(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
