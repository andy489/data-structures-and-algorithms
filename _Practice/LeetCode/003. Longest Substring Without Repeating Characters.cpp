// Smart sliding window
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Time: O(n)

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = (int)s.size();
        int lo = 0, hi = 0, mxlen = 0;
        int used[256] = {0};
        while(hi < n) {
            if(used[s[hi]]) {
                lo = max(lo, used[s[hi]]);
            }
            used[s[hi]] = hi + 1;
            mxlen = max(mxlen, hi++ - lo + 1);
        }
    return mxlen;
    }
};
