# https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/

class Solution:
    def countOrders(self, n: int) -> int:
        MOD = 10**9 + 7
        ans = 1
        for k in range(1, n+1):
            ans = ans * (2*k-1) % MOD * k % MOD
        return ans
