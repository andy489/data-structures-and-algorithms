# https://leetcode.com/problems/letter-case-permutation/

class Solution:
    def letterCasePermutation(self, s: str) -> list[str]:
        result = []
        def backtrack(i, path):
            if i == len(s):
                result.append(''.join(path))
                return
            path.append(s[i])
            backtrack(i + 1, path)
            if s[i].isalpha():
                path[-1] = s[i].swapcase()
                backtrack(i + 1, path)
            path.pop()
        backtrack(0, [])
        return result
