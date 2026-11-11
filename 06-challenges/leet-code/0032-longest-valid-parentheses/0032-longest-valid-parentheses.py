# https://leetcode.com/problems/longest-valid-parentheses/

# Solution: Stack — O(n) time, O(n) space
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        ans = 0
        for i, ch in enumerate(s):
            if ch == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    ans = max(ans, i - stack[-1])
        return ans


# Solution 2: Two-Pass Counters — O(n) time, O(1) space
class Solution2:
    def longestValidParentheses(self, s: str) -> int:
        ans = open_ = close = 0
        for ch in s:
            if ch == '(':
                open_ += 1
            else:
                close += 1
            if open_ == close:
                ans = max(ans, 2 * close)
            elif close > open_:
                open_ = close = 0
        open_ = close = 0
        for ch in reversed(s):
            if ch == '(':
                open_ += 1
            else:
                close += 1
            if open_ == close:
                ans = max(ans, 2 * open_)
            elif open_ > close:
                open_ = close = 0
        return ans
