// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

// Solution: Digit Extraction — O(log n) time, O(1) space
// Solution: Digit Extraction — O(log n) time, O(1) space
class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n > 0) {
            int d = n % 10;
            product *= d;
            sum += d;
            n /= 10;
        }
        return product - sum;
    }
}
