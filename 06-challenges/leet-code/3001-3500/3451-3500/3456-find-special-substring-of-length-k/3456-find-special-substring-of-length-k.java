// https://leetcode.com/problems/find-special-substring-of-length-k/

// Solution: Run-Length Encoding — O(n) time, O(1) space
class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == c) {
                j++;
            }
            int len = j - i;
            if (len == k) {
                boolean validBefore = (i == 0 || s.charAt(i - 1) != c);
                boolean validAfter = (j == n || s.charAt(j) != c);
                if (validBefore && validAfter) {
                    return true;
                }
            }
            i = j;
        }
        return false;
    }
}
