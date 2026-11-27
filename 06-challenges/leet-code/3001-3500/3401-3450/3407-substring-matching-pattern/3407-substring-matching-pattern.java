// https://leetcode.com/problems/substring-matching-pattern/
class Solution {
    public boolean hasMatch(String s, String p) {
        int starIdx = p.indexOf('*');
        String prefix = p.substring(0, starIdx);
        String suffix = p.substring(starIdx + 1);
        int n = s.length();
        int pLen = prefix.length(), sLen = suffix.length();
        for (int i = 0; i + pLen <= n; i++) {
            if (s.startsWith(prefix, i)) {
                int start = i + pLen;
                for (int j = start; j + sLen <= n; j++) {
                    if (s.startsWith(suffix, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
