# https://leetcode.com/problems/mean-of-array-after-removing-some-elements/

class Solution:
    def trimMean(self, arr: list[int]) -> float:
        arr.sort()
        n = len(arr)
        trim = n // 20
        return sum(arr[trim:n - trim]) / (n - 2 * trim)
