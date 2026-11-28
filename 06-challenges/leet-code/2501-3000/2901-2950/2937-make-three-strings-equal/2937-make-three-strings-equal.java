// https://leetcode.com/problems/make-three-strings-equal/

// Solution: Longest Common Prefix — O(min(n1,n2,n3)) time, O(1) space
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int prefix = 0;
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                prefix++;
            } else {
                break;
            }
        }
        if (prefix == 0) {
            return -1;
        }
        return (s1.length() - prefix) + (s2.length() - prefix) + (s3.length() - prefix);
    }
}
