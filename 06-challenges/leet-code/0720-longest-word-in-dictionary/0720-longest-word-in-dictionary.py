# https://leetcode.com/problems/longest-word-in-dictionary/

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        seen = {""}
        ans = ""
        for word in words:
            if word[:-1] in seen:
                seen.add(word)
                if len(word) > len(ans):
                    ans = word
        return ans
