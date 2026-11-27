# https://leetcode.com/problems/minimum-number-of-frogs-croaking/

class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        c = r = o = a = k = max_frogs = 0
        for ch in croakOfFrogs:
            if ch == 'c': c += 1
            elif ch == 'r':
                if c == 0: return -1
                c -= 1; r += 1
            elif ch == 'o':
                if r == 0: return -1
                r -= 1; o += 1
            elif ch == 'a':
                if o == 0: return -1
                o -= 1; a += 1
            elif ch == 'k':
                if a == 0: return -1
                a -= 1; k += 1
            max_frogs = max(max_frogs, c + r + o + a)
        return max_frogs if c == r == o == a == 0 else -1
