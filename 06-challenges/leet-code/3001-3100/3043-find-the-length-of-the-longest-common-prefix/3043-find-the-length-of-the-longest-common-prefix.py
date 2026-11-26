# https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

class Solution:
    def longestCommonPrefix(self, arr1: list[int], arr2: list[int]) -> int:
        prefixes = set()
        for x in arr1:
            while x > 0:
                prefixes.add(x)
                x //= 10
        max_len = 0
        for y in arr2:
            while y > 0:
                if y in prefixes:
                    max_len = max(max_len, len(str(y)))
                    break
                y //= 10
        return max_len
