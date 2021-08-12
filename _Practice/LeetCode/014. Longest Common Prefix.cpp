// https://leetcode.com/problems/longest-common-prefix/
// Time: O(nlog(n)*m), where n is the size of strs and m = min(sizes(strs))

class Solution {
public:
    string longestCommonPrefix(vector <string> &strs) {
        sort(strs.begin(), strs.end());
        string l = strs[0], r = strs.back();
        int i = 0, SIZE = min(l.size(), r.size());
        for (; i < SIZE; ++i) if (l[i] != r[i]) break;
        return l.substr(0, i);
    }
};
