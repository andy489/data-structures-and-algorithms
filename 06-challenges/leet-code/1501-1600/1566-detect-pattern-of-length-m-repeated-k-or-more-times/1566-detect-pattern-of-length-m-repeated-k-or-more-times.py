# https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

class Solution:
    def containsPattern(self, arr: list[int], m: int, k: int) -> bool:
        n = len(arr)
        count = 0
        for i in range(n - m):
            if arr[i] != arr[i + m]:
                count = 0
            else:
                count += 1
                if count == m * (k - 1):
                    return True
        return False
