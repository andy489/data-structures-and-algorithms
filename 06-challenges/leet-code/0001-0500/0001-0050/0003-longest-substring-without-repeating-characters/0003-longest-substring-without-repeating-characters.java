// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Smart sliding window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int SIZE = s.length();

        int lo = 0;
        int hi = 0;
        int mxlen = 0;
       
        final int ASCII = 256;

        int[] used = new int[ASCII];
        while (hi < SIZE) {
            if (used[s.charAt(hi)] != 0) {
                lo = Math.max(lo, used[s.charAt(hi)]);
            }

            used[s.charAt(hi)] = hi + 1;
            mxlen = Math.max(mxlen, hi - lo + 1);

            hi++;
        }

        return mxlen;
    }
}
