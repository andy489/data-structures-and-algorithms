# https://leetcode.com/problems/generate-parentheses/

# Solution: Backtracking — O(4ⁿ / √n) time, O(n) space
class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        result = []

        def backtrack(s, open, close):
            if len(s) == 2 * n:
                result.append(s)
                return
            if open < n:
                backtrack(s + "(", open + 1, close)
            if close < open:
                backtrack(s + ")", open, close + 1)

        backtrack("", 0, 0)
        return result
