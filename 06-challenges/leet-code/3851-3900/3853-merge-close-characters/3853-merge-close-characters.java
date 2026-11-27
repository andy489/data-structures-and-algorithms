// https://leetcode.com/problems/merge-close-characters/

class Solution {
    public String mergeCloseCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        boolean merged = true;
        while (merged) {
            merged = false;
            outer:
            for (int i = 0; i < sb.length(); i++) {
                for (int j = i + 1; j <= Math.min(i + k, sb.length() - 1); j++) {
                    if (sb.charAt(i) == sb.charAt(j)) {
                        sb.deleteCharAt(j);
                        merged = true;
                        break outer;
                    }
                }
            }
        }
        return sb.toString();
    }
}
