# https://leetcode.com/problems/the-k-strongest-values-in-an-array/

class Solution:
    def getStrongest(self, arr: list[int], k: int) -> list[int]:
        arr.sort()
        n = len(arr)
        m = arr[(n-1)//2]
        l, r = 0, n-1
        res = []
        for _ in range(k):
            if arr[r] - m >= m - arr[l]:
                res.append(arr[r]); r -= 1
            else:
                res.append(arr[l]); l += 1
        return res
