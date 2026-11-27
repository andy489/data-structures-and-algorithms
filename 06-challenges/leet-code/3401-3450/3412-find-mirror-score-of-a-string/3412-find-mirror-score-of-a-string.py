# https://leetcode.com/problems/find-mirror-score-of-a-string/
class Solution:
    def calculateScore(self, s: str) -> int:
        stacks = [[] for _ in range(26)]
        score = 0
        for i, ch in enumerate(s):
            c = ord(ch) - ord('a')
            mirror = 25 - c
            if stacks[mirror]:
                j = stacks[mirror].pop()
                score += i - j
            else:
                stacks[c].append(i)
        return score
