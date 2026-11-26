# https://leetcode.com/problems/find-lucky-integer-in-an-array/

from collections import Counter

class Solution:
    def findLucky(self, arr: list[int]) -> int:
        cnt = Counter(arr)
        return max((v for v in cnt if cnt[v]==v), default=-1)
