// https://leetcode.com/problems/add-digits/

// Solution 1: Digital Root (Math) — O(1) time, O(1) space
class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }
}

// Solution 2: Simulation — O(log num) time, O(1) space
class Solution2 {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
