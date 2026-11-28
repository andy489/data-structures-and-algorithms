# https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/

class Solution:
    def getWordsInLongestSubsequence(self, words: list[str], groups: list[int]) -> list[str]:
        n = len(words)
        dp = [1] * n
        prev = [-1] * n

        def hamming(a, b):
            return sum(x != y for x, y in zip(a, b))

        best = 0
        for i in range(1, n):
            for j in range(i):
                if (groups[j] != groups[i]
                        and len(words[j]) == len(words[i])
                        and hamming(words[j], words[i]) == 1):
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        prev[i] = j
            if dp[i] > dp[best]:
                best = i

        result = []
        cur = best
        while cur != -1:
            result.append(words[cur])
            cur = prev[cur]
        return result[::-1]
