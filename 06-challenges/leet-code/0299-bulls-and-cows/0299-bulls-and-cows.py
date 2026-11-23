# https://leetcode.com/problems/bulls-and-cows/

class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        bulls = cows = 0
        count = [0] * 10
        for s, g in zip(secret, guess):
            s, g = int(s), int(g)
            if s == g:
                bulls += 1
            else:
                if count[s] < 0:
                    cows += 1
                if count[g] > 0:
                    cows += 1
                count[s] += 1
                count[g] -= 1
        return f"{bulls}A{cows}B"
