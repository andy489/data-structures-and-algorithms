# https://leetcode.com/problems/truncate-sentence/

class Solution:
    def truncateSentence(self, s: str, k: int) -> str:
        return ' '.join(s.split()[:k])
