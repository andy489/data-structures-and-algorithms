# https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

class Solution:
    def maxFreq(self, s: str, maxLetters: int, minSize: int, maxSize: int) -> int:
        from collections import defaultdict
        freq = defaultdict(int)
        res = 0
        for i in range(len(s)-minSize+1):
            sub = s[i:i+minSize]
            if len(set(sub)) <= maxLetters:
                freq[sub] += 1
                res = max(res, freq[sub])
        return res
