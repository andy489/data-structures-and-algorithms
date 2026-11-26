// https://leetcode.com/problems/the-kth-factor-of-n/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++)
            if (n % i == 0 && --k == 0) return i;
        return -1;
    }
}
