# https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/

class Solution:
    def splitString(self, s: str) -> bool:
        def backtrack(start: int, prev: int, count: int) -> bool:
            if start == len(s):
                return count >= 2
            num = 0
            for end in range(start, len(s)):
                num = num * 10 + int(s[end])
                if num > 10**15:
                    break
                if prev == -1 or num == prev - 1:
                    if backtrack(end + 1, num, count + 1):
                        return True
            return False

        return backtrack(0, -1, 0)
