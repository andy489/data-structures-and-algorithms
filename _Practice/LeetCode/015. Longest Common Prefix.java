// https://leetcode.com/problems/longest-common-prefix/
// Time: O(S*log(n)), where S = sum of all characters in strs

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int SIZE = strs.length, minLen = strs[0].length(), i = 0;
        String l = strs[0], r = strs[SIZE - 1];
        for (; i < minLen; ++i) if (l.charAt(i) != r.charAt(i)) break;
        return l.substring(0, i);
    }
}
