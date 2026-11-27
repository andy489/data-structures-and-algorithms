// https://leetcode.com/problems/calculate-money-in-leetcode-bank/

// Solution: Math Formula — O(1) time, O(1) space
class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int fullWeeks = 7 * weeks * (weeks - 1) / 2 + 28 * weeks;
        int partial = days * (weeks + 1) + days * (days - 1) / 2;
        return fullWeeks + partial;
    }
}
