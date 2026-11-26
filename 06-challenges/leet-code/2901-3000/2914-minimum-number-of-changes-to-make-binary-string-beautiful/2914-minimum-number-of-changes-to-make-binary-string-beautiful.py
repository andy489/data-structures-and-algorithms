# https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

# Solution 1: Greedy Pair Scan — O(n) time, O(1) space
class Solution:
    def minChanges(self, s: str) -> int:
        return sum(s[i] != s[i + 1] for i in range(0, len(s), 2))


# Solution 2: Greedy Segment Scan — O(n) time, O(1) space
class Solution2:
    def minChanges(self, s: str) -> int:
        changes, length = 0, 1
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                length += 1
            else:
                if length % 2 == 1:
                    changes += 1
                length = 1
        return changes
