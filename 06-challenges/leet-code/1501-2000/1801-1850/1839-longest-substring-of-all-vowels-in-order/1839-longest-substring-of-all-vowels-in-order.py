# https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

class Solution:
    def longestBeautifulSubstring(self, word: str) -> int:
        rank = {c: i for i, c in enumerate("aeiou")}
        ans = start = 0
        distinct = 1
        for i in range(1, len(word)):
            cur, prev = rank[word[i]], rank[word[i - 1]]
            if cur == prev:
                pass
            elif cur == prev + 1:
                distinct += 1
            else:
                start = i
                distinct = 1
            if distinct == 5:
                ans = max(ans, i - start + 1)
        return ans
