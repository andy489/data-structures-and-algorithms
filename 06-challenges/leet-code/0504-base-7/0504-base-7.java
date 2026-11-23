// https://leetcode.com/problems/base-7/

// Solution: Repeated Division — O(log7(n)) time, O(log7(n)) space
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
