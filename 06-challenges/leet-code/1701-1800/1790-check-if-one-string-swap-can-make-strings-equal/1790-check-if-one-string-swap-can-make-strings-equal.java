// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

// Solution: Collect Differing Positions — O(n) time, O(1) space
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int i = -1, j = -1;
        for (int idx = 0; idx < s1.length(); idx++) {
            if (s1.charAt(idx) != s2.charAt(idx)) {
                if (i == -1) {
                    i = idx;
                } else if (j == -1) {
                    j = idx;
                } else {
                    return false;
                }
            }
        }
        if (i == -1) {
            return true;
        }
        if (j == -1) {
            return false;
        }
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
