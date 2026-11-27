# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        if not digits:
            return []

        pad = ['abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        res = []

        def backtrack(i: int, current: str) -> None:
            if i == len(digits):
                res.append(current)
                return
            for c in pad[ord(digits[i]) - ord('2')]:
                backtrack(i + 1, current + c)

        backtrack(0, '')
        return res
