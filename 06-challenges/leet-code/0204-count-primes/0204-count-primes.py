# https://leetcode.com/problems/count-primes/

class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 2:
            return 0
        is_composite = [False] * n
        i = 2
        while i * i < n:
            if not is_composite[i]:
                for j in range(i * i, n, i):
                    is_composite[j] = True
            i += 1
        return sum(1 for i in range(2, n) if not is_composite[i])
