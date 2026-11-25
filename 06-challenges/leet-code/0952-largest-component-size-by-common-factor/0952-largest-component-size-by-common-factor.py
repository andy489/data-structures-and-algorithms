# https://leetcode.com/problems/largest-component-size-by-common-factor/

class Solution:
    def largestComponentSize(self, nums: list[int]) -> int:
        max_val = max(nums)
        parent = list(range(max_val + 1))

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a, b):
            parent[find(a)] = find(b)

        for n in nums:
            f = 2
            while f * f <= n:
                if n % f == 0:
                    union(n, f)
                    union(n, n // f)
                f += 1

        from collections import Counter
        count = Counter(find(n) for n in nums)
        return max(count.values())
