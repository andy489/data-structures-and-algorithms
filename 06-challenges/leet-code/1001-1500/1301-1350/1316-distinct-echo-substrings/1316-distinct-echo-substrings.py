# https://leetcode.com/problems/distinct-echo-substrings/

class Solution:
    def distinctEchoSubstrings(self, text: str) -> int:
        n = len(text)
        seen = set()
        for k in range(1, n//2+1):
            for i in range(n - 2*k + 1):
                sub = text[i:i+2*k]
                if sub[:k] == sub[k:]:
                    seen.add(sub)
        return len(seen)
