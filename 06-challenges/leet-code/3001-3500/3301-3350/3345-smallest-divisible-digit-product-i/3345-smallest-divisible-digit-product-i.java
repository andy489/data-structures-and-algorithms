// https://leetcode.com/problems/smallest-divisible-digit-product-i/

// Solution: Linear Scan — O(1) time (bounded n), O(1) space
class Solution {
    public int smallestNumber(int n, int t) {
        for (int x = n; ; x++) {
            if (digitProduct(x) % t == 0) {
                return x;
            }
        }
    }

    private int digitProduct(int x) {
        int prod = 1;
        while (x > 0) {
            prod *= x % 10;
            x /= 10;
        }
        return prod;
    }
}
