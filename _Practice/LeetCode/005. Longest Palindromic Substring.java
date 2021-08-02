// Оptimized brute force
// https://leetcode.com/problems/longest-palindromic-substring/
// Time: O(n^2)

class Solution {
    private int substrLength(Pair<Integer, Integer> substr) {
        return substr.getValue() - substr.getKey() + 1;
    }
    
    private Pair<Integer, Integer> expandPalindrome(String s, int l, int r) {
        int SIZE = s.length();
        while (0 <= l && r < SIZE && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new Pair<>(l + 1, r);
    }
    
    public String longestPalindrome(String s) {
        int SIZE = s.length();
        Pair<Integer, Integer> mxPal = new Pair<>(0, 0);
        for (int i = 0; i < SIZE; ++i) {
            Pair<Integer, Integer> odd = expandPalindrome(s, i, i);
            Pair<Integer, Integer> even = expandPalindrome(s, i, i + 1);

            if (substrLength(mxPal) < substrLength(odd)) {
                mxPal = odd;
            }
            if (substrLength(mxPal) < substrLength(even)) {
                mxPal = even;
            }
        }
        return s.substring(mxPal.getKey(), mxPal.getValue());
    }
}
