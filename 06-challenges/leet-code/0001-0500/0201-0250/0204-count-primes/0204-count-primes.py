# https://leetcode.com/problems/count-primes/

# Solution 1: Sieve of Eratosthenes
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


# Solution 2: Linear Sieve (Sieve of Euler)
class Solution2:
    def countPrimes(self, n: int) -> int:
        if n < 2:
            return 0
        is_composite = [False] * n
        primes = []
        for i in range(2, n):
            if not is_composite[i]:
                primes.append(i)
            for p in primes:
                if i * p >= n:
                    break
                is_composite[i * p] = True
                if i % p == 0:
                    break
        return len(primes)


# Solution 3: Segmented Sieve
class Solution3:
    def countPrimes(self, n: int) -> int:
        if n < 2:
            return 0
        import math
        limit = int(math.isqrt(n))
        is_composite = [False] * (limit + 1)
        small_primes = []
        for i in range(2, limit + 1):
            if not is_composite[i]:
                small_primes.append(i)
                for j in range(i * i, limit + 1, i):
                    is_composite[j] = True
        count = 0
        low = 2
        while low < n:
            high = min(low + limit, n)
            block = bytearray(high - low)
            for p in small_primes:
                start = max(p * p, -(-low // p) * p)
                for j in range(start, high, p):
                    block[j - low] = 1
            count += block.count(0)
            low = high
        return count

