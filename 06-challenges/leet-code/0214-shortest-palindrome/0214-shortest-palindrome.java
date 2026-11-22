// https://leetcode.com/problems/shortest-palindrome/

// Solution: KMP Failure Function — O(n) time, O(n) space
class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String t = s + "#" + rev;
        int[] fail = new int[t.length()];
        for (int i = 1; i < t.length(); i++) {
            int j = fail[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = fail[j - 1];
            }
            if (t.charAt(i) == t.charAt(j)) {
                j++;
            }
            fail[i] = j;
        }
        int k = fail[t.length() - 1];
        return rev.substring(0, s.length() - k) + s;
    }
}
