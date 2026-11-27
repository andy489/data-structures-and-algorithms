# https://leetcode.com/problems/intervals-between-identical-elements/
from collections import defaultdict

class Solution:
    def getDistances(self, arr: list[int]) -> list[int]:
        n = len(arr)
        result = [0] * n
        indices = defaultdict(list)
        for i, v in enumerate(arr):
            indices[v].append(i)
        for group in indices.values():
            k = len(group)
            prefix = [0] * (k + 1)
            for j in range(k):
                prefix[j + 1] = prefix[j] + group[j]
            total = prefix[k]
            for j in range(k):
                idx = group[j]
                left = idx * j - prefix[j]
                right = (total - prefix[j + 1]) - idx * (k - j - 1)
                result[idx] = left + right
        return result
