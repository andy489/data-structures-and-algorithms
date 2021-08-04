// https://leetcode.com/problems/reverse-integer/
// Time: O(length(n))

class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res * ((Integer.MIN_VALUE <= res && res <= Integer.MAX_VALUE) ? 1 : 0);
    }
}
