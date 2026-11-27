# https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime/
class Solution:
    def minimumOperations(self, nums: list[int]) -> int:
        LIMIT = 200010

        # Sieve of Eratosthenes
        is_composite = bytearray(LIMIT)
        is_composite[0] = 1
        is_composite[1] = 1
        for i in range(2, int(LIMIT ** 0.5) + 1):
            if not is_composite[i]:
                for j in range(i * i, LIMIT, i):
                    is_composite[j] = 1

        # Build next prime lookup (smallest prime >= i)
        next_prime = [0] * LIMIT
        cur = -1
        for i in range(LIMIT - 1, -1, -1):
            if not is_composite[i]:
                cur = i
            next_prime[i] = cur

        # Build next composite lookup (smallest non-prime >= i)
        next_composite = [0] * LIMIT
        cur = -1
        for i in range(LIMIT - 1, -1, -1):
            if is_composite[i]:
                cur = i
            next_composite[i] = cur

        ops = 0
        for i, num in enumerate(nums):
            if i % 2 == 0:
                ops += next_prime[num] - num
            else:
                ops += next_composite[num] - num
        return ops
