// https://leetcode.com/problems/isomorphic-strings/

// Solution: Bidirectional Map — O(n) time, O(1) space
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sToT = new int[128];
        int[] tToS = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (sToT[cs] != 0 && sToT[cs] != ct) {
                return false;
            }

            if (tToS[ct] != 0 && tToS[ct] != cs) {
                return false;
            }

            sToT[cs] = ct;
            tToS[ct] = cs;
        }

        return true;
    }
}
