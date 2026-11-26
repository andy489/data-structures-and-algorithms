// https://leetcode.com/problems/break-a-palindrome/

// Solution: Greedy — O(n) time, O(n) space
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        char[] c = palindrome.toCharArray();
        for (int i = 0; i < n/2; i++) {
            if (c[i] != 'a') {
                c[i] = 'a';
                return new String(c);
            }
        }
        c[n-1] = 'b';
        return new String(c);
    }
}
