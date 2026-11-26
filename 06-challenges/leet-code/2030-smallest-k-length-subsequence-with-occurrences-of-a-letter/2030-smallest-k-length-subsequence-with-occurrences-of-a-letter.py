# https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/

class Solution:
    def smallestSubsequence(self, s: str, k: int, letter: str, repetition: int) -> str:
        n = len(s)
        lc = s.count(letter)
        stack = []
        lin = 0
        for i, c in enumerate(s):
            rem = n - i - 1
            while stack:
                top = stack[-1]
                if top > c and len(stack) - 1 + rem + 1 >= k:
                    need_let = lin - (1 if top == letter else 0)
                    avail_let = lc - (1 if c == letter else 0)
                    if need_let + avail_let + (1 if c == letter else 0) >= repetition:
                        if top == letter:
                            lin -= 1
                            lc += 1
                        stack.pop()
                    else:
                        break
                else:
                    break
            if len(stack) < k:
                stack.append(c)
                if c == letter:
                    lin += 1
                    lc -= 1
                else:
                    lc -= 0
            else:
                if c == letter:
                    lc -= 1
        return ''.join(stack[:k])
