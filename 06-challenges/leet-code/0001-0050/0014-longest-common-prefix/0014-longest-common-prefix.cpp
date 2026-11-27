// https://leetcode.com/problems/longest-common-prefix/

class Solution {
public:
    string longestCommonPrefix(vector <string> &strs) {
        sort(strs.begin(), strs.end());

        string l = strs[0];
        string r = strs.back();

        int i = 0;
        const int SIZE = l.size();

        for (; i < SIZE; ++i) {
            if (l[i] != r[i]) {
                break;
            }
        }

        return l.substr(0, i);
    }
};
