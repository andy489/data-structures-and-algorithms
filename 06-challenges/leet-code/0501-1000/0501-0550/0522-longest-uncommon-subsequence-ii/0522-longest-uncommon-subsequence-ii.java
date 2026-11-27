// https://leetcode.com/problems/longest-uncommon-subsequence-ii/

// Solution: Brute Force with Subsequence Check — O(n²·L) time, O(1) space
class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isSubseqOfOther = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSubseqOfOther = true;
                    break;
                }
            }
            if (!isSubseqOfOther) {
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }

    private boolean isSubsequence(String s, String t) {
        int sIdx = 0;
        for (int tIdx = 0; tIdx < t.length() && sIdx < s.length(); tIdx++) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
        }
        return sIdx == s.length();
    }
}
