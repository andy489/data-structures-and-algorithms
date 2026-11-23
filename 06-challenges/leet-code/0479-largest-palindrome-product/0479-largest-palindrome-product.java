// https://leetcode.com/problems/largest-palindrome-product/

// Solution: Enumerate Upper Halves — O(10^n) time, O(1) space
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        long maxVal = (long) Math.pow(10, n) - 1;
        long minVal = (long) Math.pow(10, n - 1);
        for (long upper = maxVal; upper >= minVal; upper--) {
            long palindrome = buildPalindrome(upper);
            for (long divisor = maxVal; divisor * divisor >= palindrome; divisor--) {
                if (palindrome % divisor == 0) {
                    long other = palindrome / divisor;
                    if (other >= minVal && other <= maxVal) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }
        return 0;
    }

    private long buildPalindrome(long upper) {
        String s = Long.toString(upper);
        String reversed = new StringBuilder(s).reverse().toString();
        return Long.parseLong(s + reversed);
    }
}
