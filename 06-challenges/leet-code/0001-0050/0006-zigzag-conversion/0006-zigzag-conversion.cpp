// https://leetcode.com/problems/zigzag-conversion/

class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        vector <string> rows(numRows);
        int i = 0;
        int step = 0;

        string res;
        for (char c : s) {
            rows[i].push_back(c);

            if (i == 0) {
                step = 1;
            }

            if (i == numRows - 1) {
                step = -1;
            }

            i += step;
        }
        for (int i = 0; i < numRows; ++i) {
            res += rows[i];
        }

        return res;
    }
};
