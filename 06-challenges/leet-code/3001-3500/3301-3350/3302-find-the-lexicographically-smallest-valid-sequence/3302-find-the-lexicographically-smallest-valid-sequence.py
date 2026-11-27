# https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/

from typing import List


class Solution:
    def validSequence(self, word1: str, word2: str) -> List[int]:
        n, m = len(word1), len(word2)
        suf = [0] * (n + 1)
        j = m - 1
        for i in range(n - 1, -1, -1):
            if j >= 0 and word1[i] == word2[j]:
                j -= 1
            suf[i] = m - 1 - j

        ans = []
        idx = 0
        used_change = False
        for i in range(n):
            if idx == m:
                break
            if word1[i] == word2[idx]:
                ans.append(i)
                idx += 1
            elif not used_change and idx + suf[i + 1] >= m:
                ans.append(i)
                idx += 1
                used_change = True

        return ans if idx == m else []
