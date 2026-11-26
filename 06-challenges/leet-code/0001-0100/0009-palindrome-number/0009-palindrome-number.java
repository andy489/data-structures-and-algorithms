// https://leetcode.com/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {
        int l = 0;
        int r = (int) (Math.log10(x) + 1);

        while (l <= r) {
            if (x < 0 || x / (int) Math.pow(10, l++) % 10 != x / (int) Math.pow(10, --r) % 10) {
                return false;
            }
        }

        return true;
    }
}
