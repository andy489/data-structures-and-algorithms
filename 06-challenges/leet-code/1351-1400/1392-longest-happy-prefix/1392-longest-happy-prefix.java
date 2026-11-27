// https://leetcode.com/problems/longest-happy-prefix/

// Solution: KMP failure function — O(n) time, O(n) space
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] kmp = new int[n];
        for (int i = 1; i < n; i++) {
            int j = kmp[i-1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = kmp[j-1];
            if (s.charAt(i) == s.charAt(j)) j++;
            kmp[i] = j;
        }
        return s.substring(0, kmp[n-1]);
    }
}
