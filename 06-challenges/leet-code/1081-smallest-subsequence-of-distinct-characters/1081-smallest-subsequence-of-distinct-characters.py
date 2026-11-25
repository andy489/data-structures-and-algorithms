# https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

class Solution:
    def smallestSubsequence(self, s: str) -> str:
        last = {c: i for i, c in enumerate(s)}
        stack, seen = [], set()
        for i, c in enumerate(s):
            if c in seen:
                continue
            while stack and stack[-1] > c and last[stack[-1]] > i:
                seen.discard(stack.pop())
            stack.append(c)
            seen.add(c)
        return ''.join(stack)
