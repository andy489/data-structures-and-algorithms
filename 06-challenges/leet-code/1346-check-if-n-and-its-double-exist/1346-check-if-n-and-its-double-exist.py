# https://leetcode.com/problems/check-if-n-and-its-double-exist/

class Solution:
    def checkIfExist(self, arr: list[int]) -> bool:
        seen = set()
        for v in arr:
            if v*2 in seen or (v%2==0 and v//2 in seen):
                return True
            seen.add(v)
        return False
