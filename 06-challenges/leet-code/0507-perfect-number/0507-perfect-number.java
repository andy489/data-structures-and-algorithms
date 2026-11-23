// https://leetcode.com/problems/perfect-number/

// Solution: Trial Division up to √n — O(√n) time, O(1) space
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; (long) i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}
