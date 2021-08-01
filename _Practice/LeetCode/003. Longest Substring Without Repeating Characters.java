// Smart sliding window
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Time: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int lo = 0, hi = 0, mxlen = 0;
        int[] used = new int[256];
        while (hi < n) {
            if (used[s.charAt(hi)] != 0) {
                lo = Math.max(lo, used[s.charAt(hi)]);
            }
            used[s.charAt(hi)] = hi + 1;
            mxlen = Math.max(mxlen, hi++ - lo + 1);
        }
        return mxlen;
    }
}
