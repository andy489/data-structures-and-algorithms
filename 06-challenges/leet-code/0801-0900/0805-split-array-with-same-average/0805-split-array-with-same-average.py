# https://leetcode.com/problems/split-array-with-same-average/

class Solution:
    def splitArraySameAverage(self, nums: list[int]) -> bool:
        n, total = len(nums), sum(nums)
        if not any((total * k) % n == 0 for k in range(1, n // 2 + 1)):
            return False
        half = n // 2
        left_sums = [set() for _ in range(half + 1)]
        left_sums[0].add(0)
        for i in range(half):
            for k in range(i, -1, -1):
                for s in left_sums[k]:
                    left_sums[k + 1].add(s + nums[i])
        for k in range(1, half + 1):
            if (total * k) % n == 0 and total * k // n in left_sums[k]:
                return True
        right_sums = [set() for _ in range(n - half + 1)]
        right_sums[0].add(0)
        for i in range(half, n):
            for k in range(i - half, -1, -1):
                for s in right_sums[k]:
                    right_sums[k + 1].add(s + nums[i])
        for lk in range(1, half + 1):
            for rk in range(1, n - half + 1):
                tk = lk + rk
                if tk > n // 2 or (total * tk) % n != 0:
                    continue
                need = total * tk // n
                for ls in left_sums[lk]:
                    if need - ls in right_sums[rk]:
                        return True
        return False
