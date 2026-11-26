// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/

// Solution: Math — O(n) time, O(1) space
class Solution {
    public int countOrders(int n) {
        long MOD = 1_000_000_007L, ans = 1;
        for (int k = 1; k <= n; k++) {
            ans = ans * (2*k-1) % MOD * k % MOD;
        }
        return (int)ans;
    }
}
