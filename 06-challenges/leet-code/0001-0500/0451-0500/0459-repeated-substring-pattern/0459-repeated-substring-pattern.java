// https://leetcode.com/problems/repeated-substring-pattern/

// Solution: String Rotation Trick — O(n) time, O(n) space
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}

// Solution 2: KMP Failure Function — O(n) time, O(n) space
class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        int period = n - lps[n - 1];
        return lps[n - 1] > 0 && n % period == 0;
    }
}
