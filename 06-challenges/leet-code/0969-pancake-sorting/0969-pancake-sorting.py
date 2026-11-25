# https://leetcode.com/problems/pancake-sorting/

class Solution:
    def pancakeSort(self, arr: list[int]) -> list[int]:
        res = []
        for size in range(len(arr), 1, -1):
            max_idx = arr.index(max(arr[:size]))
            if max_idx == size - 1:
                continue
            if max_idx != 0:
                arr[:max_idx + 1] = arr[:max_idx + 1][::-1]
                res.append(max_idx + 1)
            arr[:size] = arr[:size][::-1]
            res.append(size)
        return res
