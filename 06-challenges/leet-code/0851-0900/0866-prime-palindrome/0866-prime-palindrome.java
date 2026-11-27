// https://leetcode.com/problems/prime-palindrome/

// Solution: Generate Odd-Length Palindromes — O(10^(d/2) * sqrt(10^d)) time, O(1) space
class Solution {
    public int primePalindrome(int n) {
        for (int len = 1; len <= 9; len += 2) {
            int start = (int) Math.pow(10, (len - 1) / 2);
            int end = (int) Math.pow(10, (len + 1) / 2);
            for (int half = start; half < end; half++) {
                int pal = buildPalindrome(half, len);
                if (pal >= n && isPrime(pal)) {
                    return pal;
                }
            }
        }
        return -1;
    }

    private int buildPalindrome(int half, int len) {
        String s = Integer.toString(half);
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 2; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; (long) i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
