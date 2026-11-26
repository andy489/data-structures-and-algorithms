# https://leetcode.com/problems/rearrange-words-in-a-sentence/

class Solution:
    def arrangeWords(self, text: str) -> str:
        words = text.lower().split()
        words.sort(key=len)
        words[0] = words[0].capitalize()
        return ' '.join(words)
