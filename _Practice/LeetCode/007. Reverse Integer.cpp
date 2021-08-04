// https://leetcode.com/problems/reverse-integer/
// Time: O(length(n))

class Solution {
public:
    int reverse(int x) {
        long res = 0;
        while (x) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res * (INT_MIN <= res && res <= INT_MAX);
    }
};
