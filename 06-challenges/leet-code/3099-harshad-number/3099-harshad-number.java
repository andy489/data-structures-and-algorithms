// https://leetcode.com/problems/harshad-number/

// Solution: Digit Sum — O(D) time, O(1) space
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int s = 0, tmp = x;
        while (tmp > 0) { s += tmp % 10; tmp /= 10; }
        return x % s == 0 ? s : -1;
    }
}
