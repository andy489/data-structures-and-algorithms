# https://leetcode.com/problems/create-sorted-array-through-instructions/

class Solution:
    def createSortedArray(self, instructions: list[int]) -> int:
        MOD = 10 ** 9 + 7
        MAX = 100_001
        bit = [0] * (MAX + 1)

        def update(i):
            while i <= MAX:
                bit[i] += 1
                i += i & -i

        def query(i):
            s = 0
            while i > 0:
                s += bit[i]
                i -= i & -i
            return s

        cost = 0
        for idx, v in enumerate(instructions):
            less = query(v - 1)
            greater = idx - query(v)
            cost += min(less, greater)
            update(v)
        return cost % MOD
