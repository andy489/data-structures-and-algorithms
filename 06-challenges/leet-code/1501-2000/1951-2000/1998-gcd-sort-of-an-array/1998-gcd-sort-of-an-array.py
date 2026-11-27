# https://leetcode.com/problems/gcd-sort-of-an-array/
class Solution:
    def gcdSort(self, nums: list[int]) -> bool:
        max_val = max(nums)
        parent = list(range(max_val + 1))

        def find(x: int) -> int:
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a: int, b: int) -> None:
            ra, rb = find(a), find(b)
            if ra != rb:
                parent[ra] = rb

        for x in nums:
            temp = x
            p = 2
            while p * p <= temp:
                if temp % p == 0:
                    union(x, p)
                    while temp % p == 0:
                        temp //= p
                p += 1
            if temp > 1:
                union(x, temp)

        sorted_nums = sorted(nums)
        for orig, tgt in zip(nums, sorted_nums):
            if find(orig) != find(tgt):
                return False
        return True
