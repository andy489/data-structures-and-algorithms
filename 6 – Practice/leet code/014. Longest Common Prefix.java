// https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        final int SIZE = strs.length;
        int minLen = strs[0].length();

        String l = strs[0];
        String r = strs[SIZE - 1];

        int i = 0;
        for (; i < minLen; ++i) {
            if (l.charAt(i) != r.charAt(i)) {
                break;
            }
        }

        return l.substring(0, i);
    }
}