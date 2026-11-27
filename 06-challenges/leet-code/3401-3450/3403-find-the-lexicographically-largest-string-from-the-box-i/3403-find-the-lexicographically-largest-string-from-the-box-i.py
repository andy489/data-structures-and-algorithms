# https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/
class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        if numFriends == 1:
            return word
        n = len(word)
        best = ""
        for i in range(n):
            max_len = n - (numFriends - 1) - i
            if max_len <= 0:
                break
            candidate = word[i:i + max_len]
            if candidate > best:
                best = candidate
        return best
