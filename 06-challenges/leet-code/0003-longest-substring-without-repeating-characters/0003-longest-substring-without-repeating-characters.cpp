// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Sliding window

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        const int SIZE = s.size();
        int lo = 0;
        int hi = 0;
        
        int mxlen = 0;
        
        const int ASCII = 256;
        int used[ASCII] = {0};
        
        while(hi < SIZE) {
            if(used[s[hi]]) {
                lo = max(lo, used[s[hi]]);
            }
            
            used[s[hi]] = hi + 1;
            mxlen = max(mxlen, hi - lo + 1);
            
            ++hi;
        }
        
        return mxlen;
    }
};
