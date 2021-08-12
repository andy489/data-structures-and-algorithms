// https://leetcode.com/problems/longest-common-prefix/
// Time: O(S*log(n)), where S = sum of all characters in strs

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        sort(strs.begin(), strs.end());
        string l = strs[0], r = strs.back();
        int i = 0, SIZE = l.size();
        for(; i < SIZE; ++i) if(l[i] != r[i]) break;
        return l.substr(0, i);
    }
};
