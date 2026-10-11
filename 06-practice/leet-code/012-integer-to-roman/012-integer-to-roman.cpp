// https://leetcode.com/problems/integer-to-roman/

class Solution {
public:
    string intToRoman(int num) {
        const string romans[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        const int numerals[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        string res;

        while (num) {
            for (int i = 12; i >= 0;) {
                int x = num / numerals[i];

                while (x--) {
                    res += romans[i];
                }

                num %= numerals[i--];
            }
        }

        return res;
    }
};
