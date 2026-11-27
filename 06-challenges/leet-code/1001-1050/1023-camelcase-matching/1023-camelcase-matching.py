# https://leetcode.com/problems/camelcase-matching/

class Solution:
    def camelMatch(self, queries: list[str], pattern: str) -> list[bool]:
        def matches(query):
            j = 0
            for c in query:
                if j < len(pattern) and c == pattern[j]:
                    j += 1
                elif c.isupper():
                    return False
            return j == len(pattern)
        return [matches(q) for q in queries]
