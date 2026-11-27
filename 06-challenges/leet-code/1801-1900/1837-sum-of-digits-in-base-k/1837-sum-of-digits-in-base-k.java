// https://leetcode.com/problems/sum-of-digits-in-base-k/

// Solution: Repeated Division — O(log_k n) time, O(1) space
class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
}
