// https://leetcode.com/problems/palindrome-number/

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        unsigned rev = 0;
        unsigned copy = x;
        
        while (copy) {
            rev = rev * 10 + copy % 10;
            copy /= 10;
        }

        return (rev == (unsigned) x);
    }
};
