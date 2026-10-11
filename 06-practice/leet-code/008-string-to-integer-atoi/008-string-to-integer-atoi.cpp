// https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public:

    int myAtoi(string s) {
        long res = 0;
        int i = 0;
        bool neg = 0;

        while (isspace(s[i++])) ;

        if (s[--i] == '-' || s[i] == '+') {
            neg = (s[i++] == '-');
        }

        while (isdigit(s[i])) {
            res = res * 10 + s[i++] - '0';

            if (res > INT_MAX) {
                return neg ? INT_MIN : INT_MAX;
            }
        }

        return neg ? -res : res;
    }
};
