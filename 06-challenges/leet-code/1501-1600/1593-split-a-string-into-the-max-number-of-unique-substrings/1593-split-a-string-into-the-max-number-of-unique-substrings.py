# https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        self.max_count = 0

        def backtrack(start: int, used: set) -> None:
            if len(s) - start + len(used) <= self.max_count:
                return
            if start == len(s):
                self.max_count = max(self.max_count, len(used))
                return
            for end in range(start + 1, len(s) + 1):
                sub = s[start:end]
                if sub not in used:
                    used.add(sub)
                    backtrack(end, used)
                    used.remove(sub)

        backtrack(0, set())
        return self.max_count
