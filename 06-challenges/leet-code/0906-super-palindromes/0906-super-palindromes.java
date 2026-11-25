// https://leetcode.com/problems/super-palindromes/

// Solution: Enumerate Palindrome Roots — O(10^5) time, O(1) space
class Solution {
    public int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left), R = Long.parseLong(right);
        int count = 0;
        for (int k = 1; k < 100000; k++) {
            String s = Integer.toString(k);
            // odd length
            StringBuilder sb = new StringBuilder(s);
            for (int i = s.length() - 2; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            long p = Long.parseLong(sb.toString());
            long sq = p * p;
            if (sq > R) {
                break;
            }
            if (sq >= L && isPalindrome(sq)) {
                count++;
            }
            // even length
            sb = new StringBuilder(s);
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            p = Long.parseLong(sb.toString());
            sq = p * p;
            if (sq > R) {
                break;
            }
            if (sq >= L && isPalindrome(sq)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(long x) {
        String s = Long.toString(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
