# https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        def max_window(flip):
            l = cnt = res = 0
            for r, c in enumerate(answerKey):
                if c == flip:
                    cnt += 1
                while cnt > k:
                    if answerKey[l] == flip:
                        cnt -= 1
                    l += 1
                res = max(res, r - l + 1)
            return res
        return max(max_window('T'), max_window('F'))
